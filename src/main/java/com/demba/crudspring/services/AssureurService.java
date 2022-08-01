package com.demba.crudspring.services;

import java.util.List;


import com.demba.crudspring.dto.AssureursDto;


public interface AssureurService {
AssureursDto save(AssureursDto dto);
	
	AssureursDto findById(Integer id);
	
	AssureursDto findByNom(String nom);
	
	List<AssureursDto> findAll();
	
	void delete(Integer id);
}
