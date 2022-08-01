package com.demba.crudspring.dto;
import java.time.Instant;

import com.demba.crudspring.model.Responses;


import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ResponsesDto {

	private Integer id;
	
	 
	private String nom;
	

	private String adresse;

	 
	private String telephone;


	private String email;
	
	
	private Integer disponibilite;
	
	
	private Responses response;
	

	private Instant published_at;
	
	
	private Instant created_by;
	 

	
	private Instant updated_by;
	
	
	private Instant created_at;
	 


	private Instant updated_at;


	private String localisation;
	
	 
	private Double latitude;
	
	
	private Double longitude;

	public static ResponsesDto fromEntity(Responses response) {
		if(response == null) {
			return null;
		//TODO exception
		}
		
		return ResponsesDto.builder()
				.id(response.getId())
				.nom(response.getNom())
				.adresse(response.getAdresse())
				.telephone(response.getTelephone())
				.email(response.getEmail())
				.disponibilite(response.getDisponibilite())
				.localisation(response.getLocalisation())
				.latitude(response.getLatitude())
				.longitude(response.getLongitude())
				.build();
				
		
	}
	
	public static Responses toEntity(ResponsesDto responsesDto) {
		  if(responsesDto == null) {
			  return null;
		  }
		  Responses response = new Responses();
		  response.setId(responsesDto.getId());
		  response.setNom(responsesDto.getNom());
		  response.setAdresse(responsesDto.getAdresse());
		  response.setTelephone(responsesDto.getTelephone());
		  response.setEmail(responsesDto.getEmail());
		  response.setDisponibilite(responsesDto.getDisponibilite());
		  response.setLocalisation(responsesDto.getLocalisation());
		  response.setLatitude(responsesDto.getLatitude());
		  response.setLongitude(responsesDto.getLongitude());
		  return response;
	  }

}
