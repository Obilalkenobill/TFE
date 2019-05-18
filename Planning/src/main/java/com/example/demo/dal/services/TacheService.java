package com.example.demo.dal.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dal.entities.Patient;
import com.example.demo.dal.entities.Tache;
import com.example.demo.dal.repo.TacheRepository;

@Service
public class TacheService implements CrudService<Tache, Long>{
@Autowired
private TacheRepository repo;
	@Override
	public Iterable<? extends Tache> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Tache> getById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Tache create(Tache entity) {
		// TODO Auto-generated method stub
		return repo.save(entity);
	}

	@Override
	public Tache update(Tache entity, Long id) throws Exception {
		// TODO Auto-generated method stub
		Tache t=getById(id).orElseThrow(()->new Exception("Tache non trouvée"));
		if(entity.getJour()!=null){t.setJour(entity.getJour());}
		if(entity.getHeure()!=null){t.setHeure(entity.getHeure());}
		if(entity.getItache()!=null) {t.setItache(entity.getItache());}
		if(entity.getInfirmier()!=null) {t.setInfirmier(entity.getInfirmier());}
		List<Patient> list1= t.getPatients();
		List<Patient> list2= entity.getPatients();
		if(list2!=null) {
			for (int i = 0; i < list2.size(); i++) {
				for (int k = 0; k < list1.size(); k++) {
					if(list2.get(i).getId()==list1.get(k).getId()){list2.remove(list2.get(i));break;}
				}	
			}
		}
		list1.addAll(list2);
		if(list2!=null) {t.setPatients(list1);}
		
		return repo.save(t);
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		
		repo.deleteById(id);
		return !repo.existsById(id);
	}

}
