package com.example.act1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.act1.model.Flower;

public interface FlowerRepository extends JpaRepository<Flower, Integer>{
	
	
	//Punto 2 implementado con con JPQL
	@Query("FROM Flower WHERE species LIKE %?1%")
	List<Flower> lookForLetter(String look);
	
	@Query(value = "SELECT * FROM flower_data WHERE petal_length BETWEEN ? AND ?", nativeQuery = true )
	List<Flower> getByPetalLengthBetween(@Param("min") double min ,@Param("max") double max);
	

	

}
