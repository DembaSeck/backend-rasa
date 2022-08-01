package com.demba.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.demba.crudspring.model.Lieuxes;

@CrossOrigin("*")
public interface LieuxesRepository extends JpaRepository<Lieuxes,Integer>{

}
