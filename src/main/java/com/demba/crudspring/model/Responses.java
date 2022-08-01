package com.demba.crudspring.model;



import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
@Table(name = "responses")
public class Responses {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "nom") 
	private String nom;
	
	@Column(name = "adresse") 
	private String adresse;

	@Column(name = "telephone") 
	private String telephone;

	@Column(name = "email") 
	private String email;
	
	@Column(name = "disponibilite") 
	private Integer disponibilite;
	
	
	@ManyToOne
	private Specialites specialite;
	
	
	
	@ManyToOne
	private Assureurs assureur;
	
	
	@CreatedDate
	@Column(name = "published_at", nullable = false)
	@JsonIgnore
	private Instant published_at;
	
	@CreatedDate
	@Column(name = "created_by", nullable = false)
	@JsonIgnore
	private Instant created_by;
	 

	@LastModifiedDate
	@Column(name = "updated_by")
	@JsonIgnore
	private Instant updated_by;
	
	@CreatedDate
	@Column(name = "created_at", nullable = false)
	@JsonIgnore
	private Instant created_at;
	 

	@LastModifiedDate
	@Column(name = "updated_at")
	@JsonIgnore
	private Instant updated_at;

	@Column(name = "localisation") 
	private String localisation;
	
	@Column(name = "latitude", nullable = true) 
	private Double latitude;
	
	@Column(name = "longitude") 
	private Double longitude;

	
	}





