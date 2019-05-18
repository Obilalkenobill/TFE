package com.example.demo.dal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dal.entities.Patient;
import com.example.demo.dal.entities.Tache;
import com.example.demo.dal.repo.PatientRepository;

@Service
public class PatientService implements CrudService<Patient, Long> {
@Autowired
private PatientRepository repo;

@Override
public Iterable<? extends Patient> getAll() {
	// TODO Auto-generated method stub
	return repo.findAll();
}

@Override
public Optional<Patient> getById(Long id) {
	// TODO Auto-generated method stub
	return repo.findById(id);
}

@Override
public Patient create(Patient entity) {
	// TODO Auto-generated method stub
	return repo.save(entity);
}

@Override
public Patient update(Patient entity, Long id) throws Exception {
	// TODO Auto-generated method stub
	Patient p=repo.findById(id).orElseThrow(()->new Exception("Id Patient introuvable"));
	if(entity.getNom()!=null) {p.setNom(entity.getNom());}
	if(entity.getPrenom()!=null) {p.setPrenom(entity.getPrenom());}
	if(entity.getDateNaiss()!=null) {p.setDateNaiss(entity.getDateNaiss());}
	if(entity.getTel()!=null) {p.setTel(entity.getTel());}
	if(entity.getNumChbre()!=null) {p.setNumChbre(entity.getNumChbre());}
	if(entity.getAdresse()!=null) {p.setAdresse(entity.getAdresse());}
	if(entity.getInfirmier()!=null) {p.setInfirmier(entity.getInfirmier());}
	List<Tache> list2=entity.getTaches();
	List<Tache> list1= p.getTaches();
	if(list2!=null) {
		for (int i = 0; i < list2.size(); i++) {
			for (int k = 0; k < list1.size(); k++) {
				if(list2.get(i).getId()==list1.get(k).getId()){list2.remove(list2.get(i));break;}
			}	
		}
	}
	list1.addAll(list2);
	if(list2!=null) {p.setTaches(list1);}
	return repo.save(p);
}

@Override
public boolean delete(Long id) {
	// TODO Auto-generated method stub
	repo.deleteById(id);
	return !repo.existsById(id);
}


}
