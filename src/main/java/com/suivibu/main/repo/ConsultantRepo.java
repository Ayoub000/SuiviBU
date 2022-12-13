package com.suivibu.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivibu.main.dao.Consultant;

@Repository
public interface ConsultantRepo extends JpaRepository<Consultant, Long>{

}
