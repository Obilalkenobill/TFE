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
@OneToMany (fetch=FetchType.LAZY,cascade = CascadeType.REMOVE)
@JsonIgnoreProperties(value= {"adresse","dateNaiss","taches","tel","infirmier"})
private List<Patient> patients;
@JoinColumn (name ="infirmier_id", nullable=true)
@OneToOne (fetch=FetchType.LAZY,cascade = CascadeType.REMOVE)
@JsonIgnoreProperties(value= {"adresse","dateNaiss","taches","tel","patients"})
private Infirmier infirmier;
}