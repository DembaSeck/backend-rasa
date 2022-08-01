/*
package com.demba.crudspring.controller;
import java.util.ArrayList;


import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.demba.crudspring.exception.ResourceNotFoundException;


import com.demba.crudspring.model.RoleName;
import com.demba.crudspring.model.User;
import com.demba.crudspring.repository.RoleRepository;
import com.demba.crudspring.repository.UserRepository;

import io.swagger.annotations.Api;

@Api("/ussers")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepository repository;
	
	@Autowired 	
	@Qualifier("authenticationManagerBean")
	AuthenticationManager authenticationManager;

	@Autowired	
	UserRepository userRepository;

	@Autowired	
	PasswordEncoder encoder;

	
	
	 @Autowired
	  RoleRepository roleRepository;

	
	 @GetMapping("/users")
	// @PreAuthorize("hasRole('ROLE_ChefProjet') or hasRole('ROLE_MembreProjet')")
	  public List<User> getAllUser() {
	    System.out.println("Get all User...");
	 
	    List<User> User = new ArrayList<>();
	    repository.findAll().forEach(User::add);
	 
	    return User;
	  }
	 @GetMapping("/MonProfil/{username}")
		  public ResponseEntity<User> getUserProfil(@PathVariable(value = "username") String name )
				  throws ResourceNotFoundException{
		    System.out.println("Get User Profil...");
		    User User = repository.findByUsername(name)
		    .orElseThrow(() -> new ResourceNotFoundException("User not found for this username :: " + name));
		  
		    return ResponseEntity.ok().body(User);
			
		
		  }
	 @GetMapping("/usersChef")
		// @PreAuthorize("hasRole('ROLE_ChefProjet') or hasRole('ROLE_MembreProjet')")
		  public List<User> getUserChef(RoleName ROLE_ChefProjet) {
		    System.out.println("Get User by role chef...");
		    
		   List<User>  User = new ArrayList<>();
		    repository.findByRolesName(ROLE_ChefProjet).forEach(User::add);
		 
		    return User;
		  }
	 @GetMapping("/usersMembre")
		// @PreAuthorize("hasRole('ROLE_ChefProjet') or hasRole('ROLE_MembreProjet')")
		  public List<User> getUserMembre(RoleName ROLE_MembreProjet) {
		    System.out.println("Get User by role Membre...");
		 
		   List<User>  User = new ArrayList<>();
		  repository.findByRolesName(ROLE_MembreProjet).forEach(User::add);
		 
		    return User;
		  }
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long UserId)
			throws ResourceNotFoundException {
		User User = repository.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + UserId));
		return ResponseEntity.ok().body(User);
	}

	 
	
	
	
	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long UserId)
			throws ResourceNotFoundException {
		User User = repository.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found  id :: " + UserId));

		repository.delete(User);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	  
	 
	  @DeleteMapping("/users/delete")
	  public ResponseEntity<String> deleteAllUser() {
	    System.out.println("Delete All User...");
	 
	    repository.deleteAll();
	 
	    return new ResponseEntity<>("All Users have been deleted!", HttpStatus.OK);
	  }
	 
	

	  @PutMapping("/users/{id}")
	  public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User User) {
	    System.out.println("Update User with ID = " + id + "...");
	 
	    Optional<User> UserInfo = repository.findById(id);
	 
	    if (UserInfo.isPresent()) {
	    	User user = UserInfo.get();
	    	user.setRoles(user.getRoles());
	    	user.setName(user.getName()); 
	    	user.setPassword(user.getPassword());
	      return new ResponseEntity<>(repository.save(user), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
}
*/