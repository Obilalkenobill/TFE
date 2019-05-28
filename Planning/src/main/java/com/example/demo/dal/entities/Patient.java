package com.example.demo.dal.entities;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=true)
	private String nom;
	@Column(nullable=true)
	private String prenom;
	@Column(nullable=true)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private String dateNaiss;
	@Column(nullable=true)
	private String tel;
	@Column(nullable=true)
	private String numChbre;
	@Column(name="tache_id",nullable=true,unique=true)
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
	@JsonIgnoreProperties(value= {"patients","infirmier"})
	private List<Tache> taches;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
	@JoinColumn(name="infirmier_id",nullable=true)
	@JsonIgnoreProperties(value= {"patients","taches","adresse"})
	private Infirmier infirmier;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
	@JoinColumn(name="adresse_id",nullable=true)
	@JsonIgnoreProperties(value= {"patients","infirmier"})
	private Adresse adresse;
	@Column(nullable=true)
	private Boolean isvalid;

}
