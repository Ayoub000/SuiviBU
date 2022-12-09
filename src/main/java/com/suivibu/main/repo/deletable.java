package com.suivibu.main.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.suivibu.main.dao.Utilisateur;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class deletable {

	@PersistenceContext
    EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public Utilisateur findByUsername(String username) {
		Query query = entityManager.createNativeQuery("SELECT * FROM utilisateur as u " +
                "WHERE u.email = '?'", Utilisateur.class);
        query.setParameter(1, username);
        List<Utilisateur> utilisateurs = query.getResultList();
        return utilisateurs.size() == 1 ? utilisateurs.get(0) : null;
	}

}
