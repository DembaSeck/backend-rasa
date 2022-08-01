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

import com.demba.crudspring.dto.ResponsesDto;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("/responses")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Transactional
public interface ResponseApi {
	@PostMapping(value ="/responses/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "l'objet response crée / modifier"),	
			@ApiResponse(code = 400, message = "l'objet response n'est pas valide")	
			
	})
	ResponsesDto save(@RequestBody  ResponsesDto dto);
	
	
	@GetMapping(value ="/responses/{idresponse}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "l'objet response a été trouvé dans la BDD"),	
			@ApiResponse(code = 404, message = "aucune response n'existe dans la BDD avec l'id fourni")	
			
	})
	ResponsesDto findById(@PathVariable("idresponse") Integer id);

	
	@GetMapping(value ="/responses/{nom}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "l'objet response a été trouvé dans la BDD"),	
			@ApiResponse(code = 404, message = "aucune response n'existe dans la BDD avec le nom fourni")	
	})
	ResponsesDto findByNom(@PathVariable("nom") String nom);
	
	
	@GetMapping(value ="/responses/all",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Renvoie La Liste des Responses" ,notes = "cette methode permet d'afficher la liste des responses", responseContainer = "List<ResponsesDto>")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "la liste des responses/liste vides"),	
			
	})
	List<ResponsesDto> findAll();
	
	
	@DeleteMapping(value ="/responses/delete/{idresponse}")
	@ApiOperation(value = "Supprimer une response" ,notes = "cette methode permet de Supprimer une response", response = ResponsesDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "l'objet specialite a été supprimer de la BDD"),	
				
	})
	void delete(@PathVariable("idresponse") Integer id);
}
