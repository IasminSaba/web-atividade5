package br.ufc.crateus.trabalho.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufc.crateus.trabalho.model.Car;



public interface CarRepository extends JpaRepository<Car, Integer>{
	
	@Query(value = "SELECT * FROM cars WHERE marca=?", nativeQuery = true)
	List<Car> findByMarca(String marca);
	
	//Modo 1
	@Query(value = "SELECT * FROM cars LIMIT ?1", nativeQuery = true)
	List<Car> findByQuantidade(Integer quantidade);
}
