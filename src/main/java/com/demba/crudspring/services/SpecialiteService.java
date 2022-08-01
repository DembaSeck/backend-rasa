package com.demba.crudspring.services;

import java.util.List;

import com.demba.crudspring.dto.SpecialiteDto;

public interface SpecialiteService {

	SpecialiteDto save(SpecialiteDto dto);
	
	SpecialiteDto findById(Integer id);
	
	SpecialiteDto findByNom(String nom);
	
	List<SpecialiteDto> findAll();
	
	void delete(Integer id);
}
