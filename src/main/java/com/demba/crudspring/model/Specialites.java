package com.demba.crudspring.model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "specialites")
public class Specialites{
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "nom") 
	private String nom;
	 
	@Column(name = "patterns") 
	private String patterns;
	/*
	@OneToMany(mappedBy="specialite", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	@JsonProperty(access=Access.WRITE_ONLY)
	*/
	@OneToMany(mappedBy="specialite")
	private Collection<Responses> responses;

	/*
	   @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "specialite_lieuxes", 
	      joinColumns = @JoinColumn(name = "specialite_id"), 
	      inverseJoinColumns = @JoinColumn(name = "lieux_id"))
	    private Set<Lieuxes> lieuxes = new HashSet<>();
	     */
	   @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "lieuxes_specialites_specialite_lieuxes", 
	      joinColumns = @JoinColumn(name = "specialite_id"), 
	      inverseJoinColumns = @JoinColumn(name = "lieux_id"))
	    private Collection<Lieuxes> lieuxes;
	  
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
	  
	
	
	  @Column(name = "url_photo") 
	  private String url_photo;

}
