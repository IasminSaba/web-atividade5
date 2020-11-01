package br.ufc.crateus.trabalho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.crateus.trabalho.model.Car;
import br.ufc.crateus.trabalho.repository.CarRepository;


@Service
public class CarService {
	 @Autowired
	 CarRepository carRepo;
	    
	 public Car addCar(String nome,String marca,String anoFabricacao, String anoModelo, String dataVenda) {
	      Car car = new Car(nome, marca, anoFabricacao, anoModelo, dataVenda);
	      return carRepo.save(car);
	 } 
	    
     public boolean removeCar(Integer id) {
    	 if(carRepo.existsById(id)) {
	          carRepo.deleteById(id);
	          return true;
        }

    	 return false;
	 }
	    
	 public List<Car> getCars() {
	     return carRepo.findAll();
	 }
	 
	 public Car getCar(Integer id) {
	        return carRepo.findById(id).get();
	 }
	    
	
	 public Car updateCar(int id, String nome,String marca,String anoFabricacao, String anoModelo, String dataVenda) {
	     Car carAux = carRepo.findById(id).get();
	        
	     if(carAux != null) {
	         carAux.setNome(nome);
	         carAux.setMarca(marca);
	         carAux.setAnoFabricacao(anoFabricacao);
	         carAux.setAnoModelo(anoModelo);
	         carAux.setDataVenda(dataVenda);
	        
	         carRepo.save(carAux);         
	     }
	        
	     return carAux;
	 }
	 

	 public List<Car> getByMarca(String marca){
		 return carRepo.findByMarca(marca);
	 }
	 
	 
	 public List<Car> getByQuantidade(int quantidade){
		 return carRepo.findByQuantidade(quantidade);
	 }
	 
	 //Modo 2
//	 @PersistenceContext
//	 private EntityManager entityManager;
//	 
//	 public List<Car> getByQuantidade(int quantidade){
//		 List<Car> porQtd = entityManager.createQuery("SELECT car from cars car ORDER BY car.id", Car.class)
//				 .setMaxResults(quantidade).getResultList();
//		 return porQtd;
//	 }
}
