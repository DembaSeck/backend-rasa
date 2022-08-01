package com.demba.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.demba.crudspring.model.Responses;

@CrossOrigin("*")
public interface ResponsesRepository extends JpaRepository<Responses,Integer>{

}
