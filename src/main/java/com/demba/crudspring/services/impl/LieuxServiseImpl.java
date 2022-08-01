package com.demba.crudspring.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demba.crudspring.dto.LieuxesDto;
import com.demba.crudspring.exception.EntityNotFoundException;
import com.demba.crudspring.exception.ErrorCodes;
import com.demba.crudspring.exception.InvalidEntityException;
import com.demba.crudspring.model.Lieuxes;
import com.demba.crudspring.repository.LieuxesRepository;
import com.demba.crudspring.services.LieuxService;
import com.demba.crudspring.validator.LieuxValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LieuxServiseImpl implements LieuxService{

private LieuxesRepository lieuxesRepository;
	
	@Autowired
	public LieuxServiseImpl(LieuxesRepository lieuxesRepository) {
		this.lieuxesRepository= lieuxesRepository;
	}

	@Override
	public LieuxesDto save(LieuxesDto dto) {
		List<String> errors = LieuxValidator.valide(dto);
		if(!errors.isEmpty()) {
			log.error("Lieux is not valide{}",dto);
			throw new InvalidEntityException("l'entite n'est pas valide",ErrorCodes.LIEUXES_NOT_VALID,errors);
			
		}
			
		return LieuxesDto.fromEntity(
				lieuxesRepository.save(
						LieuxesDto.toEntity(dto)
						));
	}

	@Override
	public LieuxesDto findById(Integer id) {
		if(id == null) {
			log.error("Lieux Id is null");
			return null;
		}
		
		Optional<Lieuxes> Lieux = lieuxesRepository.findById(id);
		
		 return Optional.of(LieuxesDto.fromEntity(Lieux.get())).orElseThrow(() ->
		new EntityNotFoundException(
				"Aucun Lieux Avec L'Id:" + id + " n'a ete trouve dans la BDD",
				ErrorCodes.LIEUXES_NOT_FOUND)
				
				);
	}
	
	 
	

	@Override
	public LieuxesDto findByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LieuxesDto> findAll() {
		
		return lieuxesRepository.findAll().stream()
				.map(LieuxesDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
			log.error("Lieux Id is null");
			return;
		}
		
		lieuxesRepository.deleteById(id);
	}
}
