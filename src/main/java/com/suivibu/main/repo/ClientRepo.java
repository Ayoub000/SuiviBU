package com.suivibu.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivibu.main.dao.Client;


@Repository
public interface ClientRepo extends JpaRepository<Client, Long>{

}
