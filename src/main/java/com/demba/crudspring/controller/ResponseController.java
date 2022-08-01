package com.demba.crudspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demba.crudspring.controller.api.ResponseApi;
import com.demba.crudspring.dto.ResponsesDto;
import com.demba.crudspring.services.ResponseService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Transactional
public class ResponseController implements ResponseApi{
	

	private ResponseService responseService;
	
	
	@Autowired
	public ResponseController(ResponseService responseService){
	this.responseService = responseService;
	}
	
	
	@Override
	public ResponsesDto save(ResponsesDto dto) {
		return responseService.save(dto);
	}

	@Override
	public ResponsesDto findById(Integer id) {
		return responseService.findById(id);
	}

	@Override
	public ResponsesDto findByNom(String nom) {
		return responseService.findByNom(nom);
		
	}

	@Override
	public List<ResponsesDto> findAll() {
		
		return responseService.findAll();
	}

	@Override
	public void delete(Integer id) {
		responseService.delete(id);
		
	}


}
