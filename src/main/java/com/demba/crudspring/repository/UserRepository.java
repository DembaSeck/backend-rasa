package com.demba.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.demba.crudspring.model.RoleName;
import com.demba.crudspring.model.User;

@CrossOrigin("*")
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
List<User> findByRolesName(RoleName rolename);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
