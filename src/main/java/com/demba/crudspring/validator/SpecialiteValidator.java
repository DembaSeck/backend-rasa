package com.demba.crudspring.validator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;

import com.demba.crudspring.dto.SpecialiteDto;
public class SpecialiteValidator {
	public static List<String> valide(SpecialiteDto specialiteDto)  {
		
		List<String> errors = new ArrayList<>();
		
    	if(specialiteDto == null || !StringUtils.hasLength(specialiteDto.getNom())){
    		errors.add("veuillez renseigner  un Nom valide");
    	}
	
	return errors;
  }

	
}