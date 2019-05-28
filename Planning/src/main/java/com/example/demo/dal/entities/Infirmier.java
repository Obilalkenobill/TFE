package com.example.demo.dal.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Data;
@Entity
@Data
public class Infirmier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private String dateNaiss;
	@Column(nullable=true)
	private String tel;
	@Column (nullable = true)
	@OneToMany
	@JsonIgnoreProperties(value= {"infirmier","patients"})
	private List<Tache> taches;
	@Column
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value= {"infirmier","taches"})
	private List<Patient> patients;
	@OneToOne
	@JoinColumn(name="adresse_id",nullable = true)
	@JsonIgnoreProperties(value= {"infirmier","patients"})
	private Adresse adresse;
}
