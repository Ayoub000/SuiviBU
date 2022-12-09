package com.suivibu.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivibu.main.dao.Utilisateur;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {

	Utilisateur findByUsername(String username);
}
