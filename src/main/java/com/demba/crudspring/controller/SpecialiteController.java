package com.demba.crudspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demba.crudspring.controller.api.SpecialiteApi;
import com.demba.crudspring.dto.SpecialiteDto;
import com.demba.crudspring.services.SpecialiteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Transactional
public class SpecialiteController implements SpecialiteApi{
	
	private SpecialiteService specialiteService;
	
	
	@Autowired
	public SpecialiteController(SpecialiteService specialiteService){
	this.specialiteService = specialiteService;
	}
	
	
	@Override
	public SpecialiteDto save(SpecialiteDto dto) {
		return specialiteService.save(dto);
	}

	@Override
	public SpecialiteDto findById(Integer id) {
		return specialiteService.findById(id);
	}

	@Override
	public SpecialiteDto findByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SpecialiteDto> findAll() {
		
		return specialiteService.findAll();
	}

	@Override
	public void delete(Integer id) {
		specialiteService.delete(id);
		
	}

	 
}
