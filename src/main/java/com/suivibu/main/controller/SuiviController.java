package com.suivibu.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivibu.main.dao.EntretienAnnuel;
import com.suivibu.main.dao.SuiviProjetClient;
import com.suivibu.main.dao.SuiviProjetTalent;
import com.suivibu.main.service.SuiviService;



@RestController
@RequestMapping(value = "/suivi")
public class SuiviController {
	
	@Autowired
	private SuiviService suiviService;
	
	

	@GetMapping(value = "/spc")
	public ResponseEntity<?> getSpcs()
	{
		return ResponseEntity.ok(suiviService.fetchSpcs());
	}
	
	
	@GetMapping(value = "/spt")
	public ResponseEntity<?> getSpts()
	{
		return ResponseEntity.ok(suiviService.fetchSpts());
	}
	
	@GetMapping(value = "/ea")
	public ResponseEntity<?> getEas()
	{
		return ResponseEntity.ok(suiviService.fetchEas());
	}
	
	@GetMapping(value = "/spc/{id}")
	public ResponseEntity<?> getSpc(@PathVariable long id)
	{
		return ResponseEntity.ok(suiviService.fetchSpc(id));
	}
	
	
	@GetMapping(value = "/spt/{id}")
	public ResponseEntity<?> getSpt(@PathVariable long id)
	{
		return ResponseEntity.ok(suiviService.fetchSpt(id));
	}
	
	@GetMapping(value = "/ea/{id}")
	public ResponseEntity<?> getEa(@PathVariable long id)
	{
		return ResponseEntity.ok(suiviService.fetchEa(id));
	}
	
	
	@PostMapping(value = "/spt")
	public ResponseEntity<?> addSpt(@RequestBody SuiviProjetTalent spt)
	{
		SuiviProjetTalent newSpt = null;
		HttpStatus status = null;
		try
		{
			newSpt = suiviService.addSpt(spt);
			status = HttpStatus.CREATED;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = HttpStatus.BAD_REQUEST;
		}
		
		
		return newSpt != null ? ResponseEntity.status(status).body(newSpt) : ResponseEntity.status(status).build();
	}
	
	
	@PostMapping(value = "/spc")
	public ResponseEntity<?> addSpt(@RequestBody SuiviProjetClient spc)
	{
		SuiviProjetClient newSpc = null;
		HttpStatus status = null;
		try
		{
			newSpc = suiviService.addSpc(spc);
			status = HttpStatus.CREATED;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = HttpStatus.BAD_REQUEST;
		}
		
		
		return newSpc != null ? ResponseEntity.status(status).body(newSpc) : ResponseEntity.status(status).build();
	}
	
	
	@PostMapping(value = "/ea")
	public ResponseEntity<?> addEa(@RequestBody EntretienAnnuel ea)
	{
		EntretienAnnuel newEa = null;
		HttpStatus status = null;
		try
		{
			newEa = suiviService.addEa(ea);
			status = HttpStatus.CREATED;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = HttpStatus.BAD_REQUEST;
		}
		
		
		return newEa != null ? ResponseEntity.status(status).body(newEa) : ResponseEntity.status(status).build();
	}
	
	@PutMapping(value = "/spt/{id}")
	public ResponseEntity<?> updateSpt(@PathVariable long id, @RequestBody SuiviProjetTalent spt)
	{
		SuiviProjetTalent updatedSpt = null;
		HttpStatus status = null;
		try
		{
			updatedSpt = suiviService.updateSpt(id, spt);
			status = HttpStatus.CREATED;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = HttpStatus.BAD_REQUEST;
		}
		
		
		return updatedSpt != null ? ResponseEntity.status(status).body(updatedSpt) : ResponseEntity.status(status).build();
	}
	
	
	@PutMapping(value = "/spc/{id}")
	public ResponseEntity<?> updateSpt(@PathVariable long id, @RequestBody SuiviProjetClient spc)
	{
		SuiviProjetClient updatedSpc = null;
		HttpStatus status = null;
		try
		{
			updatedSpc = suiviService.updateSpc(id, spc);
			status = HttpStatus.CREATED;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = HttpStatus.BAD_REQUEST;
		}
		
		
		return updatedSpc != null ? ResponseEntity.status(status).body(updatedSpc) : ResponseEntity.status(status).build();
	}
	
	
	@PutMapping(value = "/ea/{id}")
	public ResponseEntity<?> updateEa(@PathVariable long id, @RequestBody EntretienAnnuel ea)
	{
		EntretienAnnuel updatedEa = null;
		HttpStatus status = null;
		try
		{
			updatedEa = suiviService.updateEa(id, ea);
			status = HttpStatus.CREATED;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = HttpStatus.BAD_REQUEST;
		}
		
		
		return updatedEa != null ? ResponseEntity.status(status).body(updatedEa) : ResponseEntity.status(status).build();
	}
	
}
