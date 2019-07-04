package com.example.demo.dal.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Entity
@Data
public class Heure {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable=true, unique =true)
private String nomHeure;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNomHeure() {
	return nomHeure;
}
public void setNomHeure(String nomHeure) {
	this.nomHeure = nomHeure;
}
}