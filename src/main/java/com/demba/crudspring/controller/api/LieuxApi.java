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

import com.demba.crudspring.dto.LieuxesDto;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("/lieuxes")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Transactional
public interface LieuxApi {
	@PostMapping(value ="/lieuxes/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "l'objet lieux crée / modifier"),	
			@ApiResponse(code = 400, message = "l'objet lieux n'est pas valide")	
			
	})
	LieuxesDto save(@RequestBody  LieuxesDto dto);
	
	@GetMapping(value ="/lieuxes/{idlieux}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "l'objet lieux a été trouvé dans la BDD"),	
			@ApiResponse(code = 404, message = "aucune lieux n'existe dans la BDD avec l'id fourni")	
			
	})
	LieuxesDto findById(@PathVariable("idlieux") Integer id);
	
	
	@GetMapping(value ="/lieuxes/{nom}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "l'objet lieux a été trouvé dans la BDD"),	
			@ApiResponse(code = 404, message = "aucune lieux n'existe dans la BDD avec le nom fourni")	
	})
	LieuxesDto findByNom(@PathVariable("nom") String nom);
	
	
	@GetMapping(value ="/lieuxes/all",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Renvoie La Liste des lieux" ,notes = "cette methode permet d'afficher la liste des lieux", responseContainer = "List<lieuxesDto>")
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "la liste des lieux/liste vides"),	
			
	})
	List<LieuxesDto> findAll();
	
	@DeleteMapping(value ="/lieuxes/delete/{idlieux}")
	@ApiOperation(value = "Supprimer une response" ,notes = "cette methode permet de Supprimer une lieux", response = LieuxesDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "l'objet lieux a été supprimer de la BDD"),	
				
	})
	void delete(@PathVariable("idlieux") Integer id);
}
