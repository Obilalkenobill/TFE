package com.example.demo.dal.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dal.entities.Patient;
import com.example.demo.dal.entities.Tache;
import com.example.demo.dal.entities.User;
import com.example.demo.dal.repo.UserRepository;


@Service
public class UserService implements UserDetailsService,CrudService<User, Long>{
	
	@Autowired
	private UserRepository repo;

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		Objects.requireNonNull(username); // pour vÃ©rifier que l'username n'est pas null, ainsi pas besoin de try catch
		User u = repo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User name not found")); // orElseThrow est possible grace Ã  l'optional
		return u;
	}

	@Override
	public Iterable<? extends User> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<User> getById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public User create(User entity) {
		// TODO Auto-generated method stub
		return repo.save(entity);
	}

	@Override
	public User update(User entity, Long id) throws Exception {
		// TODO Auto-generated method stub
		User p=repo.findById(id).orElseThrow(()->new Exception("Id introuvable"));
		if(entity.getUsername()!=null) {p.setUsername(entity.getUsername());}
		if(entity.getPassword()!=null) {p.setPassword(entity.getPassword());}
		if(entity.getRoles()!=null) {p.setRoles(entity.getRoles());}
		return repo.save(p);
	}

	
	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return !repo.existsById(id);
	}

}