package com.demba.crudspring.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.demba.crudspring.dto.LieuxesDto;

public class LieuxValidator {
public static List<String> valide(LieuxesDto lieuxesDto)  {
		
		List<String> errors = new ArrayList<>();
		
    	if(lieuxesDto == null || !StringUtils.hasLength(lieuxesDto.getNom())){
    		errors.add("veuillez renseigner  un Nom valide");
    	}
	
	return errors;
  }

	
}
