package com.example.demo.dal.entities;


import java.util.HashSet;
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
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
	private iTache itache;
	@JoinColumn(name="infirmier_id",nullable=true)
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
	@JsonIgnoreProperties(value= {"adresse","taches","patients","dateNaiss"})
	private Infirmier infirmier;
	@Column(name="patient_id",nullable=true,unique=true)
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
	@JsonIgnoreProperties(value={"taches","adresse","infirmier","dateNaiss"})	
	private List<Patient> patients;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Jour getJour() {
		return jour;
	}
	public void setJour(Jour jour) {
		this.jour = jour;
	}
	public Heure getHeure() {
		return heure;
	}
	public void setHeure(Heure heure) {
		this.heure = heure;
	}
	public iTache getItache() {
		return itache;
	}
	public void setItache(iTache itache) {
		this.itache = itache;
	}
	public Infirmier getInfirmier() {
		return infirmier;
	}
	public void setInfirmier(Infirmier infirmier) {
		this.infirmier = infirmier;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}
