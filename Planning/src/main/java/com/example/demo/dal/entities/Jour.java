package com.example.demo.dal.entities;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Entity
@Data
public class Jour {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable=false, unique =true)
private String nomJour;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNomJour() {
	return nomJour;
}
public void setNomJour(String nomJour) {
	this.nomJour = nomJour;
}
}
