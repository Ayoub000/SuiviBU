package com.suivibu.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivibu.main.dao.BusinessUnit;

@Repository
public interface BusinessUnitRepo extends JpaRepository<BusinessUnit, Long>{

}
