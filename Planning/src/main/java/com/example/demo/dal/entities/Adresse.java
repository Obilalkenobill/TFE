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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
public class Adresse {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getRue() {
	return rue;
}
public void setRue(String rue) {
	this.rue = rue;
}
public String getNumeroEtBoite() {
	return numeroEtBoite;
}
public void setNumeroEtBoite(String numeroEtBoite) {
	this.numeroEtBoite = numeroEtBoite;
}
public String getCodePostale() {
	return codePostale;
}
public void setCodePostale(String codePostale) {
	this.codePostale = codePostale;
}
public String getLocalite() {
	return localite;
}
public void setLocalite(String localite) {
	this.localite = localite;
}
public String getPays() {
	return Pays;
}
public void setPays(String pays) {
	Pays = pays;
}
public List<Patient> getPatients() {
	return patients;
}
public void setPatients(List<Patient> patients) {
	this.patients = patients;
}
public Infirmier getInfirmier() {
	return infirmier;
}
public void setInfirmier(Infirmier infirmier) {
	this.infirmier = infirmier;
}
@Column(nullable=true)
private String rue;
@Column(nullable=true)
private String numeroEtBoite;
@Column(nullable=true)
private String codePostale;
@Column(nullable=true)
private String localite;
@Column(nullable=true)
private String Pays;
@Column (name ="patient_id", nullable=true)
@OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JsonIgnoreProperties(value= {"adresse","dateNaiss","taches","tel","infirmier"})
private List<Patient> patients;
@JoinColumn (name ="infirmier_id", nullable=true)
@OneToOne (fetch = FetchType.EAGER)
@JsonIgnoreProperties(value= {"adresse","dateNaiss","taches","tel","patients"})
private Infirmier infirmier;
}