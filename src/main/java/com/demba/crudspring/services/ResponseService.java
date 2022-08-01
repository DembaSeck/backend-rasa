package com.demba.crudspring.services;

import java.util.List;

import com.demba.crudspring.dto.ResponsesDto;

public interface ResponseService {
ResponsesDto save(ResponsesDto dto);
	
	ResponsesDto findById(Integer id);
	
	ResponsesDto findByNom(String nom);
	
	List<ResponsesDto> findAll();
	
	void delete(Integer id);
}
