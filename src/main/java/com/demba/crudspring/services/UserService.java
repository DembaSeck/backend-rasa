package com.demba.crudspring.services;

import java.util.List;

import com.demba.crudspring.dto.UsersDto;

public interface UserService {
UsersDto save(UsersDto dto);
	
	UsersDto findById(Integer id);
	
	UsersDto findByNom(String nom);
	
	List<UsersDto> findAll();
	
	void delete(Integer id);
}
