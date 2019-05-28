package com.example.demo.dal.services;

import java.util.Optional;


public interface CrudService<TENTITY,TID> {
Iterable<? extends TENTITY> getAll();
Optional<TENTITY> getById(TID id);
TENTITY create(TENTITY entity);
TENTITY update(TENTITY entity, TID id)throws Exception;
boolean delete(TID id) throws Exception;
}
