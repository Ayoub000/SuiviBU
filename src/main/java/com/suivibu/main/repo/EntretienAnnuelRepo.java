package com.suivibu.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivibu.main.dao.EntretienAnnuel;



@Repository
public interface EntretienAnnuelRepo extends JpaRepository<EntretienAnnuel, Long> {

}
