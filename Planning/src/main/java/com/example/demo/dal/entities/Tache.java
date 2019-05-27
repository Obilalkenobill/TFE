package com.example.demo.dal.entities;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Entity
@Data
public class Tache {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JoinColumn(name="jour_id", nullable=true)
	@ManyToOne
	private Jour jour;
	@JoinColumn (name="heure_id", nullable=true)
	@ManyToOne
	private Heure heure;
	@JoinColumn (name="itache_id", nullable=true)
	@ManyToOne
	private iTache itache;
	@JoinColumn(name="infirmier_id",nullable=true)
	@ManyToOne
	@JsonIgnoreProperties(value= {"adresse","taches","patients","dateNaiss"})
	private Infirmier infirmier;
	@Column(name="patient_id",nullable=true,unique=true)
	@ManyToMany
	@JsonIgnoreProperties(value={"taches","adresse","infirmier","dateNaiss"})	
	private List<Patient> patients;

}
