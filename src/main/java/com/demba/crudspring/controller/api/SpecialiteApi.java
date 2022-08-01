package com.demba.crudspring.controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demba.crudspring.dto.SpecialiteDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@Api("/specialites")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Transactional
public interface SpecialiteApi {
	
	

	@PostMapping(value = "crudspring/v1/specialites/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiOperation(value = "Enregistrer une Specialite" ,notes = "cette methode permet d'enregistrer ou modifier une specialite", response = SpecialiteDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "l'objet specialite crée / modifier"),	
			@ApiResponse(code = 400, message = "l'objet specialite n'est pas valide")	
			
	})
	SpecialiteDto save(@RequestBody  SpecialiteDto dto);
	
	
	@GetMapping(value ="/specialites/{idspecialite}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Rechercher une Specialite" ,notes = "cette methode permet de rechercher une specialite par son id", response = SpecialiteDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "l'objet specialite a été trouvé dans la BDD"),	
			@ApiResponse(code = 404, message = "aucune specialite n'existe dans la BDD avec l'id fourni")	
			
	})
	SpecialiteDto findById(@PathVariable("idspecialite") Integer id);
	
	
	@GetMapping(value ="/specialites/{nom}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Rechercher une Specialite par son nom" ,notes = "cette methode permet de rechercher une specialite par son nom", response = SpecialiteDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "l'objet specialite a été trouvé dans la BDD"),	
			@ApiResponse(code = 404, message = "aucune specialite n'existe dans la BDD avec le nom fourni")	
	})
	SpecialiteDto findByNom(@PathVariable("nom") String nom);
	
	
	@GetMapping(value ="/specialites/all",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Renvoie La Liste des Specialites" ,notes = "cette methode permet d'afficher la liste des specialite", responseContainer = "List<SpecialiteDto>")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "la liste des specialite/liste vides"),	
			
	})
	List<SpecialiteDto> findAll();
	
	
	@DeleteMapping(value ="/specialites/delete/{idspecialite}")
	@ApiOperation(value = "Supprimer une specialite" ,notes = "cette methode permet de Supprimer une specialite", response = SpecialiteDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "l'objet specialite a été supprimer de la BDD"),	
				
	})
	void delete(@PathVariable("idspecialite") Integer id);
}

