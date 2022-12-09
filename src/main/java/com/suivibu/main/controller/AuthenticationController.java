package com.suivibu.main.controller;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivibu.main.dao.Utilisateur;
import com.suivibu.main.mapping.JwToken;
import com.suivibu.main.mapping.JwtAuthRequest;
import com.suivibu.main.security.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {
	
	@Autowired
	JwtUtil jwtUtil;

	@Lazy
	@Autowired
	private AuthenticationManager authenticationManager;


	@PostMapping(value = "/generate")
	public ResponseEntity<?> createAuthToken(@RequestBody JwtAuthRequest authenticationRequest,
			HttpServletResponse response) throws AuthenticationException, IOException {

		// Perform the security
		Authentication authentication = null;
		try
		{
			authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(),
					authenticationRequest.getPassword()));
		}
		catch(BadCredentialsException bce)
		{
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
				

		// Inject into security context
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// token creation
		Utilisateur user = (Utilisateur) authentication.getPrincipal();
		String jws = jwtUtil.generateToken(user.getUsername());
		int expiresIn = jwtUtil.getExpiresIn();
		// Return the token
		return ResponseEntity.ok(new JwToken(jws, expiresIn));
	}

	@PostMapping(value = "/renew")
	public ResponseEntity<?> renewAuthToken(
			HttpServletRequest request,
			HttpServletResponse response,
			Principal principal) {

		String authToken = jwtUtil.getToken(request);

		if (authToken != null && principal != null) {
			String refreshedToken = jwtUtil.refreshToken(authToken);
			int expiresIn = jwtUtil.getExpiresIn();

			return ResponseEntity.ok(new JwToken(refreshedToken, expiresIn));
		} else {
			JwToken userTokenState = new JwToken();
			return ResponseEntity.accepted().body(userTokenState);
		}
	}
	
	
}
