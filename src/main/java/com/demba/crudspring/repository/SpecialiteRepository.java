package com.demba.crudspring.repository;
import com.demba.crudspring.model.Specialites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface SpecialiteRepository extends JpaRepository<Specialites,Integer>{

}