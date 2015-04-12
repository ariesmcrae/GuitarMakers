package com.ariesmcrae.guitarmakers.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ariesmcrae.guitarmakers.model.ModelType;

@Repository
public interface ModelTypeRepository extends JpaRepository<ModelType, Long>{
}
