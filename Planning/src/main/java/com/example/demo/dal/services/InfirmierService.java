package com.example.demo.dal.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dal.entities.Infirmier;
import com.example.demo.dal.repo.InfirmierRepository;

@Service
public class InfirmierService implements CrudService<Infirmier, Long>{
@Autowired
private InfirmierRepository repo;
	@Override
	public Iterable<? extends Infirmier> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Infirmier> getById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Infirmier create(Infirmier entity) {
		// TODO Auto-generated method stub
		return repo.save(entity);
	}

	@Override
	public Infirmier update(Infirmier entity, Long id) throws Exception {
		// TODO Auto-generated method stub
		Infirmier i=repo.findById(id).orElseThrow(()->new Exception ("Id infirmier introuvable"));
		if(entity.getNom()!=null) {i.setNom(entity.getNom());}
		if(entity.getPrenom()!=null) {i.setPrenom(entity.getPrenom());}
		if(entity.getDateNaiss()!=null) {i.setDateNaiss(entity.getDateNaiss());}
		if(entity.getTel()!=null) {i.setTel(entity.getTel());}
		if(entity.getTel()!=null) {i.setAdresse(entity.getAdresse());}
		if(entity.getPatients()!=null) {i.setPatients(entity.getPatients());}
		if(entity.getTaches()!=null) {i.setTaches(entity.getTaches());}
		if(entity.getIsvalid()!=null) {i.setIsvalid(entity.getIsvalid());}
		return repo.save(i);
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return !repo.existsById(id);
	}

}
