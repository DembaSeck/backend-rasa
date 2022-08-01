package com.demba.crudspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demba.crudspring.controller.api.LieuxApi;
import com.demba.crudspring.dto.LieuxesDto;
import com.demba.crudspring.services.LieuxService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Transactional
public class LieuxController implements LieuxApi{
	
private LieuxService lieuxService;
	
	
	@Autowired
	public LieuxController(LieuxService lieuxService){
	this.lieuxService = lieuxService;
	}
	
	
	@Override
	public LieuxesDto save(LieuxesDto dto) {
		return lieuxService.save(dto);
	}

	@Override
	public LieuxesDto findById(Integer id) {
		return lieuxService.findById(id);
	}

	@Override
	public LieuxesDto findByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LieuxesDto> findAll() {
		
		return lieuxService.findAll();
	}

	@Override
	public void delete(Integer id) {
		lieuxService.delete(id);
		
	}

	 
}
