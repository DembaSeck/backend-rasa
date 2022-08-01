package com.demba.crudspring.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.demba.crudspring.dto.ResponsesDto;

public class ResponseValidator {
public static List<String> valide(ResponsesDto responsesDto)  {
		
		List<String> errors = new ArrayList<>();
		
    	if(responsesDto == null || !StringUtils.hasLength(responsesDto.getNom())){
    		errors.add("veuillez renseigner  un Nom valide");
    	}
    	if(responsesDto == null || !StringUtils.hasLength(responsesDto.getAdresse())){
    		errors.add("veuillez renseigner  une Adresse valide");
    	}
    	if(responsesDto == null || !StringUtils.hasLength(responsesDto.getEmail())){
    		errors.add("veuillez renseigner  un Email valide");
    	}
 
	
	return errors;
  }

	
}
