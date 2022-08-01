package com.demba.crudspring.repository;
import com.demba.crudspring.model.Role;
import com.demba.crudspring.model.RoleName;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	 Optional<Role> findByName(RoleName roleName);
}
