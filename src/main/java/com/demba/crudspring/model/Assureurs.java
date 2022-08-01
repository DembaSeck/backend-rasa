package com.demba.crudspring.model;



import java.time.Instant;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "assureurs")
public class Assureurs {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "nom") 
	private String nom;
	
	@Column(name = "description") 
	private String description;
	
	@OneToMany(mappedBy="assureur")
	private Collection<Responses> responses;

}
