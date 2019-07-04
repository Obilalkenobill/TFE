package com.example.demo.dal.entities;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class iTache {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column
private String Type;
@Column
private String Description;
@Column (nullable = true)
private String Path;
public String getPath() {
	return Path;
}
public void setPath(String path) {
	Path = path;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getType() {
	return Type;
}
public void setType(String type) {
	Type = type;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
}