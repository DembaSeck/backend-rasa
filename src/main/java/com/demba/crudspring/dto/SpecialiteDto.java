package com.demba.crudspring.dto;
import java.time.Instant;

import com.demba.crudspring.model.Specialites;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpecialiteDto {

	private Integer id;
	
	
	private String nom;

	private String patterns;

	
	private Instant published_at;
	
	private Instant created_by;
	 
	private Instant updated_by;
	
	private Instant created_at;
	 
	private Instant updated_at;
	  
	
	  private String url_photo;

	  public static SpecialiteDto fromEntity(Specialites specialite) {
		 if(specialite == null) {
			 return null;
		//TODO EXCEPTION
		 }
		 
		 return SpecialiteDto.builder()
			.id(specialite.getId())
			.nom(specialite.getNom())
			.patterns(specialite.getPatterns())
			.url_photo(specialite.getUrl_photo())
		    .build();
	  }
	  
	  public static Specialites toEntity(SpecialiteDto specialiteDto) {
		  if(specialiteDto == null) {
			  return null;
		  }
		  Specialites specialite = new Specialites();
		  specialite.setId(specialiteDto.getId());
		  specialite.setNom(specialiteDto.getNom());
		  specialite.setPatterns(specialiteDto.getPatterns());
		  specialite.setUrl_photo(specialiteDto.getUrl_photo());
		  return specialite;
	  }
	  

	
}
