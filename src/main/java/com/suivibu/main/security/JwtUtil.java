package com.suivibu.main.security;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtUtil {
	
	@Value("${jwt.app.name}")
    private String APP_NAME;

    @Value("${jwt.secret}")
    public String SECRET;

    @Value("${jwt.token.duration}")
    private int EXPIRES_IN;
    

    private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;
    

    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public Date getIssuedAtDateFromToken(String token) {
        Date issueAt;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            issueAt = claims.getIssuedAt();
        } catch (Exception e) {
            issueAt = null;
        }
        return issueAt;
    }
    
    public String refreshToken(String token) {
        String refreshedToken;
        LocalDateTime current = LocalDateTime.now();
    	Date tokenIssue = Date.from(current.atZone(ZoneId.systemDefault()).toInstant());
    	Date tokenExpiry = Date.from(current.plusSeconds(EXPIRES_IN).atZone(ZoneId.systemDefault()).toInstant());
        
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            claims.setIssuedAt(tokenIssue);
            refreshedToken = Jwts.builder()
                .setClaims(claims)
                .setExpiration(tokenExpiry)
                .signWith(new SecretKeySpec(SECRET.getBytes(), SIGNATURE_ALGORITHM.getJcaName()))
                .compact();
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public String generateToken(String username) {
    	LocalDateTime current = LocalDateTime.now();
    	Date tokenIssue = Date.from(current.atZone(ZoneId.systemDefault()).toInstant());
    	Date tokenExpiry = Date.from(current.plusSeconds(EXPIRES_IN).atZone(ZoneId.systemDefault()).toInstant());
        
    	return Jwts.builder()
                .setIssuer("We+Aix")
                .setSubject(username)
                .setIssuedAt(tokenIssue)
                .setExpiration(tokenExpiry)
                .signWith(new SecretKeySpec(SECRET.getBytes(), SIGNATURE_ALGORITHM.getJcaName()))
                .compact();
    }

    private Claims getAllClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(new SecretKeySpec(SECRET.getBytes(), SIGNATURE_ALGORITHM.getJcaName()))
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    public int getExpiresIn() {
        return EXPIRES_IN;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (
                username != null &&
                username.equals(userDetails.getUsername())
        );
    }
    
    public String getToken(HttpServletRequest request)  {
        String authHeader = getAuthHeaderFromHeader(request);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        return null;
    }

    public String getAuthHeaderFromHeader(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }

}
