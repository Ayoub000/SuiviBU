package com.suivibu.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivibu.main.dao.SuiviProjetClient;



@Repository
public interface SuiviProjetClientRepo extends JpaRepository<SuiviProjetClient, Long>{

}
