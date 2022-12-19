package com.suivibu.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivibu.main.dao.EntretienAnnuel;
import com.suivibu.main.dao.SuiviProjetClient;
import com.suivibu.main.dao.SuiviProjetTalent;
import com.suivibu.main.repo.EntretienAnnuelRepo;
import com.suivibu.main.repo.SuiviProjetClientRepo;
import com.suivibu.main.repo.SuiviProjetTalentRepo;


@Service
public class SuiviServiceImpl implements SuiviService{

	@Autowired
	private SuiviProjetTalentRepo sptRepo;
	
	@Autowired
	private SuiviProjetClientRepo spcRepo;
	
	@Autowired
	private EntretienAnnuelRepo eaRepo;
	
	
	
	
	@Override
	public List<SuiviProjetTalent> fetchSpts() {
		return sptRepo.findAll();
	}

	@Override
	public List<SuiviProjetClient> fetchSpcs() {
		return spcRepo.findAll();
	}

	@Override
	public List<EntretienAnnuel> fetchEas() {
		return eaRepo.findAll();
	}
	
	@Override
	public SuiviProjetTalent fetchSpt(long id) {
		return sptRepo.findById(id).get();
	}

	@Override
	public SuiviProjetClient fetchSpc(long id) {
		return spcRepo.findById(id).get();
	}

	@Override
	public EntretienAnnuel fetchEa(long id) {
		return eaRepo.findById(id).get();
	}

	@Override
	public void addSuivis(SuiviProjetTalent spt, SuiviProjetClient spc, EntretienAnnuel ea) {
		sptRepo.save(spt);
		spcRepo.save(spc);
		eaRepo.save(ea);
	}

	@Override
	public SuiviProjetTalent addSpt(SuiviProjetTalent spt) {
		return sptRepo.save(spt);
	}

	@Override
	public EntretienAnnuel addEa(EntretienAnnuel ea) {
		return eaRepo.save(ea);
	}

	@Override
	public SuiviProjetClient addSpc(SuiviProjetClient spc) {
		return spcRepo.save(spc);
	}

	@Override
	public SuiviProjetTalent updateSpt(long id, SuiviProjetTalent spt) {
		SuiviProjetTalent fspt = fetchSpt(id);
		fspt.setDate(spt.getDate());
		fspt.setCommentaire(spt.getCommentaire());
		return sptRepo.save(fspt);
	}

	@Override
	public EntretienAnnuel updateEa(long id, EntretienAnnuel ea) {
		EntretienAnnuel fea = fetchEa(id);
		fea.setDate(ea.getDate());
		fea.setCommentaire(ea.getCommentaire());
		return eaRepo.save(fea);
	}

	@Override
	public SuiviProjetClient updateSpc(long id, SuiviProjetClient spc) {
		SuiviProjetClient fspc = fetchSpc(id);
		fspc.setDate(spc.getDate());
		fspc.setCommentaire(spc.getCommentaire());
		return spcRepo.save(fspc);
	}


}
