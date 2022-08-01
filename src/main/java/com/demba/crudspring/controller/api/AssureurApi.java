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

import com.demba.crudspring.dto.AssureursDto;
import com.demba.crudspring.dto.ResponsesDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("/assureurs")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Transactional
public interface AssureurApi {
	@PostMapping(value ="/assureures/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "l'objet assureur crée / modifier"),	
			@ApiResponse(code = 400, message = "l'objet assureur n'est pas valide")	
			
	})
	AssureursDto save(@RequestBody  AssureursDto dto);
	
	@GetMapping(value ="/assureures/{idassureur}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "l'objet assureur a été trouvé dans la BDD"),	
			@ApiResponse(code = 404, message = "aucune assureur n'existe dans la BDD avec l'id fourni")	
			
	})
	AssureursDto findById(@PathVariable("idassureur") Integer id);
	
	
	@GetMapping(value ="/assureures/{nom}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "l'objet assureur a été trouvé dans la BDD"),	
			@ApiResponse(code = 404, message = "aucune assureur n'existe dans la BDD avec le nom fourni")	
	})
	AssureursDto findByNom(@PathVariable("nom") String nom);
	
	
	@GetMapping(value ="/assureures/all",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Renvoie La Liste des Assureurs" ,notes = "cette methode permet d'afficher la liste des assureurs", responseContainer = "List<AssureursDto>")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "la liste des assureurs/liste vides"),	
			
	})
	List<AssureursDto> findAll();
	
	@DeleteMapping(value ="/assureures/delete/{idassureur}")
	@ApiOperation(value = "Supprimer une assureur" ,notes = "cette methode permet de Supprimer une assureur", response = AssureursDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "l'objet assureur a été supprimer de la BDD"),	
				
	})
	void delete(@PathVariable("idassureur") Integer id);
}
