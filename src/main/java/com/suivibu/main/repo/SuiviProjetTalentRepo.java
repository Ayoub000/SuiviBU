package com.suivibu.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivibu.main.dao.SuiviProjetTalent;


@Repository
public interface SuiviProjetTalentRepo extends JpaRepository<SuiviProjetTalent, Long>{
	
	

}
