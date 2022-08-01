package com.demba.crudspring.dto;
import java.time.Instant;

import com.demba.crudspring.model.Lieuxes;


import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class LieuxesDto {

	private Integer id;
	
	
	private String nom;
	
	
	private String location;
	
	
	private Instant published_at;

	private Instant created_by;
	 
	private Instant updated_by;
	
	private Instant created_at;
	 
	private Instant updated_at;

	private double latitude;
	
	private double longitude;
	
	
	 public static LieuxesDto fromEntity(Lieuxes lieux) {
		 if(lieux == null) {
			 return null;
		//TODO EXCEPTION
		 }
		 
		 return LieuxesDto.builder()
			.id(lieux.getId())
			.nom(lieux.getNom())
			.location(lieux.getLocation())
			.latitude(lieux.getLatitude())
			.longitude(lieux.getLongitude())
			.build();
			
		
	 
	  }
	
	 public static Lieuxes toEntity(LieuxesDto lieuxesDto) {
		  if(lieuxesDto == null) {
			  return null;
		  }
		  Lieuxes lieux = new Lieuxes();
		  lieux.setId(lieuxesDto.getId());
		  lieux.setNom(lieuxesDto.getNom());
		  lieux.setLocation(lieuxesDto.getLocation());
		  lieux.setLatitude(lieuxesDto.getLatitude());
		  lieux.setLongitude(lieuxesDto.getLongitude());
		  return lieux;
	  }
	

	
}
