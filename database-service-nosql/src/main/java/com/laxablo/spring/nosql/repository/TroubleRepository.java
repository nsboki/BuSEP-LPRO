package com.laxablo.spring.nosql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.laxablo.spring.nosql.entity.TroubleEntity;

@Repository
public interface TroubleRepository extends MongoRepository<TroubleEntity, String>{

}
