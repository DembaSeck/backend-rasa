package com.demba.crudspring.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.demba.crudspring.dto.AssureursDto;

public class AssureurValidator {
public static List<String> valide(AssureursDto assureursDto)  {
		
		List<String> errors = new ArrayList<>();
		
    	if(assureursDto == null || !StringUtils.hasLength(assureursDto.getNom())){
    		errors.add("veuillez renseigner  un Nom valide");
    	}
	
	return errors;
  }

}
