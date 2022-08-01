package com.demba.crudspring.model;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;

/*
import java.util.HashSet;
import java.util.Set;


import javax.persistence.FetchType;



import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
*/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "lieuxes")
public class Lieuxes {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "nom") 
	private String nom;
	
	@Column(name = "location") 
	private String location;
	
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
	/*
	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "lieuxes_specialites__specialites_lieuxes", 
	      joinColumns = @JoinColumn(name = "lieux_id"), 
	      inverseJoinColumns = @JoinColumn(name = "specialite_id"))
	    private Set<Specialites> specialite = new HashSet<>();
*/
	
	
	
	
	@Column(name = "latitude") 
	private Double latitude;
	
	@Column(name = "longitude") 
	private Double longitude;

	

}
