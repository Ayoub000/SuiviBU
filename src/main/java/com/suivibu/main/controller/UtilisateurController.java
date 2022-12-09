package com.suivibu.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	

	@PostMapping(value = "/add")
	public ResponseEntity<?> addUtilisateur(@RequestBody Utilisateur utilisateur)
	{
		
		utilisateur.setPassword(pwdEncoder.encode(utilisateur.getPassword()));
		Utilisateur newUtilisateur = null;
		HttpStatus status = null;
		try
		{
			newUtilisateur = userService.addUtilisateur(utilisateur);
			status = HttpStatus.CREATED;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = HttpStatus.BAD_REQUEST;
		}
		
		
		return newUtilisateur != null ? ResponseEntity.status(status).body(newUtilisateur) : ResponseEntity.status(status).build();
		
	}

	@PostMapping(value = "/updatePwd")
	public ResponseEntity<?> changePassword(@RequestBody UpdatePwdRequest updatePwd) {
		userService.changePassword(updatePwd.getOldPassword(), updatePwd.getNewPassword());

		return ResponseEntity.accepted().build();
	}
}
