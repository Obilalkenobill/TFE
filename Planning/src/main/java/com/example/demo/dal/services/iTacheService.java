package com.example.demo.dal.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dal.entities.iTache;
import com.example.demo.dal.repo.iTacheRepository;
@Service
public class iTacheService implements CrudService<iTache, Long> {
@Autowired
private iTacheRepository repo;
	@Override
	public Iterable<? extends iTache> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<iTache> getById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public iTache create(iTache entity) {
		// TODO Auto-generated method stub
		return repo.save(entity);
	}

	@Override
	public iTache update(iTache entity, Long id) throws Exception {
		// TODO Auto-generated method stub
		iTache i=repo.findById(id).orElseThrow(()->new Exception("Id iTache introuvable"));
		if(entity.getType()!=null) {i.setType(entity.getType());}
		if(entity.getDescription()!=null) {i.setDescription(entity.getDescription());}
		return repo.save(i);
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return !repo.existsById(id);
	}

}
