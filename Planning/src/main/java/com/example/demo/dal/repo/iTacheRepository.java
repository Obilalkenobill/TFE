package com.example.demo.dal.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dal.entities.iTache;

@Repository
public interface iTacheRepository extends JpaRepository<iTache, Long>  {

}
