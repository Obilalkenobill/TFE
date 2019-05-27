package com.example.demo.dal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dal.entities.Role;
import com.example.demo.dal.repo.RoleRepository;
import com.example.demo.dal.repo.UserRepository;
@Service
public class RoleService implements CrudService<Role, Long>{
@Autowired
private RoleRepository repo;
	@Override
	public Iterable<? extends Role> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Role> getById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Role create(Role entity) {
		// TODO Auto-generated method stub
		return repo.save(entity);
	}

	@Override
	public Role update(Role entity, Long id) throws Exception {
		// TODO Auto-generated method stub
	Role r= repo.findById(id).orElseThrow(()->new Exception("Id introuvable"));	
	if(entity.getName()!=null) {r.setName(entity.getName());}
	return repo.save(r);
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return !repo.existsById(id);
	}
	

}
