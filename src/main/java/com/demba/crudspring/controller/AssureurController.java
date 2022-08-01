package com.demba.crudspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demba.crudspring.controller.api.AssureurApi;
import com.demba.crudspring.dto.AssureursDto;
import com.demba.crudspring.services.AssureurService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Transactional
public class AssureurController implements AssureurApi {
private AssureurService assureurService;
	
	
	@Autowired
	public AssureurController(AssureurService AssureurService){
	this.assureurService = AssureurService;
	}
	
	
	@Override
	public AssureursDto save(AssureursDto dto) {
		return assureurService.save(dto);
	}

	@Override
	public AssureursDto findById(Integer id) {
		return assureurService.findById(id);
	}

	@Override
	public AssureursDto findByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AssureursDto> findAll() {
		
		return assureurService.findAll();
	}

	@Override
	public void delete(Integer id) {
		assureurService.delete(id);
		
	}

}
