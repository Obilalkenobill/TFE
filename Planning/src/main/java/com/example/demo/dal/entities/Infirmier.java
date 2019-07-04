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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDateNaiss() {
		return dateNaiss;
	}
	public void setDateNaiss(String dateNaiss) {
		this.dateNaiss = dateNaiss;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public List<Tache> getTaches() {
		return taches;
	}
	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
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
	@Column(nullable=true)
	private Boolean isvalid;
	public Boolean getIsvalid() {
		return isvalid;
	}
	public void setIsvalid(Boolean isvalid) {
		this.isvalid = isvalid;
	}
}
