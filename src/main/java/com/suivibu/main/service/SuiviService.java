package com.suivibu.main.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.suivibu.main.dao.EntretienAnnuel;
import com.suivibu.main.dao.SuiviProjetClient;
import com.suivibu.main.dao.SuiviProjetTalent;


public interface SuiviService {

	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	List<SuiviProjetTalent> fetchSpts();
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	List<SuiviProjetClient> fetchSpcs();
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	List<EntretienAnnuel> fetchEas();
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	SuiviProjetTalent fetchSpt(long id);
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	SuiviProjetClient fetchSpc(long id);
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	EntretienAnnuel fetchEa(long id);
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	void addSuivis(SuiviProjetTalent spt, SuiviProjetClient spc, EntretienAnnuel ea);
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	SuiviProjetTalent addSpt(SuiviProjetTalent spt);

	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	EntretienAnnuel addEa(EntretienAnnuel ea);

	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	SuiviProjetClient addSpc(SuiviProjetClient spc);
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	SuiviProjetTalent updateSpt(long id, SuiviProjetTalent spt);

	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	EntretienAnnuel updateEa(long id, EntretienAnnuel ea);

	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	SuiviProjetClient updateSpc(long id, SuiviProjetClient spc);
	
}
