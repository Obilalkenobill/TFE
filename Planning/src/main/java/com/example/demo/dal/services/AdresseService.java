package com.example.demo.dal.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dal.entities.Adresse;
import com.example.demo.dal.repo.AdresseRepository;
@Service
public class AdresseService implements CrudService<Adresse, Long>{
@Autowired
private AdresseRepository repo;
	@Override
	public Iterable<? extends Adresse> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Adresse> getById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Adresse create(Adresse entity) {
		// TODO Auto-generated method stub
		return repo.save(entity);
	}

	@Override
	public Adresse update(Adresse entity, Long id) throws Exception {
		// TODO Auto-generated method stub
		Adresse a=repo.findById(id).orElseThrow(()->new Exception("Adresse non trouvée"));
		if(entity.getPays()!=null) {a.setPays(entity.getPays());}
		if(entity.getLocalite()!=null) {a.setLocalite(entity.getLocalite());}
		if(entity.getCodePostale()!=null) {a.setCodePostale(entity.getCodePostale());}
		if(entity.getRue()!=null) {a.setRue(entity.getRue());}
		if(entity.getNumeroEtBoite()!=null) {a.setNumeroEtBoite(entity.getNumeroEtBoite());}
		if(entity.getInfirmier()!=null) {a.setInfirmier(entity.getInfirmier());}
		if(entity.getPatients()!=null) {a.setPatients(entity.getPatients());}
		
		return null;
	}

	@Override 
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
