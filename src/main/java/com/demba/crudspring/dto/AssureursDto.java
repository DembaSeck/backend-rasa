package com.demba.crudspring.dto;



import com.demba.crudspring.model.Assureurs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssureursDto {
	
	
	private Integer id;
	
	
	private String nom;
	
	
	private String description;
	
	 public static AssureursDto fromEntity(Assureurs assureur) {
		 if(assureur == null) {
			 return null;
		//TODO EXCEPTION
		 }
		 
		 return AssureursDto.builder()
			.id(assureur.getId())
			.nom(assureur.getNom())
			.description(assureur.getDescription())
		
			.build();
			
		
	 
	  }
	
	 public static Assureurs toEntity(AssureursDto AssureursDto) {
		  if(AssureursDto == null) {
			  return null;
		  }
		  Assureurs assureur = new Assureurs();
		  assureur.setId(AssureursDto.getId());
		  assureur.setNom(AssureursDto.getNom());
		  assureur.setDescription(AssureursDto.getDescription());
	
		  return assureur;
	  }
	
}
