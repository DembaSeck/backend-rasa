package com.demba.crudspring.model;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users", uniqueConstraints = {
       @UniqueConstraint(columnNames = {
           "username"
       }),
       @UniqueConstraint(columnNames = {
           "email"
       })
})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
		@Column(name = "name")
	    private String name;
	 
		@Column(name = "username")
	    private String username;
	 
		@Column(name = "email")
	    private String email;
	 
		@Column(name = "password")
	    private String password;
	 
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "user_roles", 
	      joinColumns = @JoinColumn(name = "user_id"), 
	      inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private Set<Role> roles = new HashSet<>();
	    /*
	    @OneToMany(mappedBy="user")
		private Collection<Projet> projets;
	    
	    @OneToMany(mappedBy="user")
		private Collection<Tache> taches;
	    */
	    
	   
	 
	    public User(String name, String username, String email, String password) {
	        this.name = name;
	        this.username = username;
	        this.email = email;
	        this.password = password;
	    }
	 
	 
}
