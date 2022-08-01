package com.demba.crudspring.services;

import java.util.List;

import com.demba.crudspring.dto.LieuxesDto;

public interface LieuxService {
LieuxesDto save(LieuxesDto dto);
	
	LieuxesDto findById(Integer id);
	
	LieuxesDto findByNom(String nom);
	
	List<LieuxesDto> findAll();
	
	void delete(Integer id);
}
