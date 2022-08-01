package com.demba.crudspring.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demba.crudspring.dto.AssureursDto;
import com.demba.crudspring.exception.EntityNotFoundException;
import com.demba.crudspring.exception.ErrorCodes;
import com.demba.crudspring.exception.InvalidEntityException;
import com.demba.crudspring.model.Assureurs;
import com.demba.crudspring.repository.AssureursRepository;

import com.demba.crudspring.services.AssureurService;
import com.demba.crudspring.validator.AssureurValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AssureurServiceImpl implements AssureurService {
private AssureursRepository assureursRepository;
	
	
	@Autowired
	public AssureurServiceImpl(AssureursRepository assureursRepository) {
		this.assureursRepository= assureursRepository;
	}	
	

	@Override
	public AssureursDto save(AssureursDto dto) {
		List<String> errors = AssureurValidator.valide(dto);
		if(!errors.isEmpty()) {
			log.error("Assureur is not valide{}",dto);
			throw new InvalidEntityException("l'entite n'est pas valide",ErrorCodes.Assureurs_Not_Found,errors);
			
		}
			
		return AssureursDto.fromEntity(
				assureursRepository.save(
						AssureursDto.toEntity(dto)
						));
	}

	@Override
	public AssureursDto findById(Integer id) {
		if(id == null) {
			log.error("Assureur Id is null");
			return null;
		}
		
		Optional<Assureurs> Assureur = assureursRepository.findById(id);
		
		 return Optional.of(AssureursDto.fromEntity(Assureur.get())).orElseThrow(() ->
		new EntityNotFoundException(
				"Aucun Assureur Avec L'Id:" + id + " n'a ete trouve dans la BDD",
				ErrorCodes.Assureurs_Not_Found)
				
				);
	}
	
	 
	

	@Override
	public AssureursDto findByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AssureursDto> findAll() {
		
		return assureursRepository.findAll().stream()
				.map(AssureursDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
			log.error("Assureur Id is null");
			return;
		}
		
		assureursRepository.deleteById(id);

}
	}