package com.suivibu.main.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivibu.main.dao.Utilisateur;
import com.suivibu.main.mapping.UpdatePwdRequest;
import com.suivibu.main.service.UtilisateurService;


@RestController
@RequestMapping(value = "/user")
public class UtilisateurController {

	@Autowired
	private UtilisateurService userService;
	
	@Autowired
	private PasswordEncoder pwdEncoder;
	
	
	
	@GetMapping(value = "/")
	public ResponseEntity<?> getUtilisateurs()
	{
		return ResponseEntity.ok(userService.fetchUtilisateurs());
	}
	
	
	@GetMapping(value = "/whoami")
	public ResponseEntity<?> getUtilisateur()
	{
		Utilisateur utilisateur = userService.fetchUtilisateur();
		Map<String, Object> response = new HashMap<String, Object>();
		Map<String, String> bu = new HashMap<String, String>();
		bu.put("idBU", String.valueOf(utilisateur.getBu().getIdBU()));
		bu.put("ville", utilisateur.getBu().getVille());
		response.put("utilisateur", utilisateur);
		response.put("bu", bu);
		return ResponseEntity.ok(response);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteUtilisateur(@PathVariable("id") long idUtilisateur)
	{
		HttpStatus status = null;
		try
		{
			userService.deleteUtilisateur(idUtilisateur);
			status = HttpStatus.ACCEPTED;
		}
		catch(AccessDeniedException e)
		{
			status = HttpStatus.UNAUTHORIZED;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).build();
	}
	
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addUtilisateur(@RequestBody Utilisateur utilisateur)
	{
		utilisateur.setPassword(pwdEncoder.encode(utilisateur.getPassword()));
		HttpStatus status = null;
		try
		{
			userService.addUtilisateur(utilisateur);
			status = HttpStatus.CREATED;
		}
		catch(AccessDeniedException e)
		{
			status = HttpStatus.UNAUTHORIZED;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = HttpStatus.BAD_REQUEST;
		}
		
		return ResponseEntity.status(status).build();
	}
	
	

	@PutMapping(value = "/pwd")
	public ResponseEntity<?> changePassword(@RequestBody UpdatePwdRequest updatePwd) {
		userService.changePassword(updatePwd.getOldPassword(), updatePwd.getNewPassword());

		return ResponseEntity.accepted().build();
	}
	
	
}
