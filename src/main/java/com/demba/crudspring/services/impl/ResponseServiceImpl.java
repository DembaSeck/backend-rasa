package com.demba.crudspring.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demba.crudspring.dto.ResponsesDto;
import com.demba.crudspring.exception.EntityNotFoundException;
import com.demba.crudspring.exception.ErrorCodes;
import com.demba.crudspring.exception.InvalidEntityException;
import com.demba.crudspring.model.Responses;
import com.demba.crudspring.repository.ResponsesRepository;
import com.demba.crudspring.services.ResponseService;
import com.demba.crudspring.validator.ResponseValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ResponseServiceImpl implements ResponseService{
	
private ResponsesRepository ResponsesRepository;
	
	@Autowired
	public ResponseServiceImpl(ResponsesRepository ResponsesRepository) {
		this.ResponsesRepository= ResponsesRepository;
	}

	@Override
	public ResponsesDto save(ResponsesDto dto) {
		List<String> errors = ResponseValidator.valide(dto);
		if(!errors.isEmpty()) {
			log.error("Responses is not valide{}",dto);
			throw new InvalidEntityException("l'entite n'est pas valide",ErrorCodes.RESPONSES_NOT_VALID,errors);
			
		}
			
		return ResponsesDto.fromEntity(
				ResponsesRepository.save(
						ResponsesDto.toEntity(dto)
						));
	}

	@Override
	public ResponsesDto findById(Integer id) {
		if(id == null) {
			log.error("Responses Id is null");
			return null;
		}
		
		Optional<Responses> Responses = ResponsesRepository.findById(id);
		
		 return Optional.of(ResponsesDto.fromEntity(Responses.get())).orElseThrow(() ->
		new EntityNotFoundException(
				"Aucun Responses Avec L'Id:" + id + " n'a ete trouve dans la BDD",
				ErrorCodes.RESPONSES_NOT_FOUND)
				
				);
	}
	
	 
	

	@Override
	public ResponsesDto findByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResponsesDto> findAll() {
		
		return ResponsesRepository.findAll().stream()
				.map(ResponsesDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
			log.error("Responses Id is null");
			return;
		}
		
		ResponsesRepository.deleteById(id);
	}

}
