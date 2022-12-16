package com.suivibu.main.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivibu.main.dao.Consultant;
import com.suivibu.main.dao.Utilisateur;

@Repository
public interface ConsultantRepo extends JpaRepository<Consultant, Long>{

	
	List<Consultant> findByUtilisateur(Utilisateur utilisateur);
}
