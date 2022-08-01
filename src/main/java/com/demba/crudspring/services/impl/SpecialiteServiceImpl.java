package com.demba.crudspring.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demba.crudspring.dto.SpecialiteDto;
import com.demba.crudspring.exception.EntityNotFoundException;
import com.demba.crudspring.exception.ErrorCodes;
import com.demba.crudspring.exception.InvalidEntityException;
import com.demba.crudspring.model.Specialites;
import com.demba.crudspring.repository.SpecialiteRepository;
import com.demba.crudspring.services.SpecialiteService;
import com.demba.crudspring.validator.SpecialiteValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SpecialiteServiceImpl implements SpecialiteService{
	
	private SpecialiteRepository specialiteRepository;
	
	@Autowired
	public SpecialiteServiceImpl(SpecialiteRepository specialiteRepository) {
		this.specialiteRepository= specialiteRepository;
	}

	@Override
	public SpecialiteDto save(SpecialiteDto dto) {
		List<String> errors = SpecialiteValidator.valide(dto);
		if(!errors.isEmpty()) {
			log.error("Specialite is not valide{}",dto);
			throw new InvalidEntityException("l'entite n'est pas valide",ErrorCodes.SPECIALITES_NOT_VALID,errors);
			
		}
			
		return SpecialiteDto.fromEntity(
				specialiteRepository.save(
						SpecialiteDto.toEntity(dto)
						));
	}

	@Override
	public SpecialiteDto findById(Integer id) {
		if(id == null) {
			log.error("Specialite Id is null");
			return null;
		}
		
		Optional<Specialites> specialite = specialiteRepository.findById(id);
		
		 return Optional.of(SpecialiteDto.fromEntity(specialite.get())).orElseThrow(() ->
		new EntityNotFoundException(
				"Aucun specialite Avec L'Id:" + id + " n'a ete trouve dans la BDD",
				ErrorCodes.SPECIALITES_NOT_FOUND)
				
				);
	}
	
	 
	

	@Override
	public SpecialiteDto findByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SpecialiteDto> findAll() {
		
		return specialiteRepository.findAll().stream()
				.map(SpecialiteDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
			log.error("Specialite Id is null");
			return;
		}
		
		specialiteRepository.deleteById(id);
	}

}
