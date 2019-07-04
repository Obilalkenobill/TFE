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
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy ="patients" )
	@JsonIgnoreProperties(value= {"patients","infirmier"})
	private List<Tache> taches;
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
	public String getNumChbre() {
		return numChbre;
	}
	public void setNumChbre(String numChbre) {
		this.numChbre = numChbre;
	}
	public List<Tache> getTaches() {
		return taches;
	}
	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}
	public Infirmier getInfirmier() {
		return infirmier;
	}
	public void setInfirmier(Infirmier infirmier) {
		this.infirmier = infirmier;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Boolean getIsvalid() {
		return isvalid;
	}
	public void setIsvalid(Boolean isvalid) {
		this.isvalid = isvalid;
	}
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
