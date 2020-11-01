package br.ufc.crateus.trabalho.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.crateus.trabalho.model.Car;
import br.ufc.crateus.trabalho.service.CarService;


@RestController
@CrossOrigin
@RequestMapping(path = "/api/cars")
public class CarController {

	@Autowired
    CarService carService;
 
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Car>> getCars() {
        return new ResponseEntity<List<Car>>(carService.getCars(), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<Car> getCar(@PathVariable("id") Integer id) {
        return new ResponseEntity<Car>(carService.getCar(id), HttpStatus.OK);
    }
    
 
    @RequestMapping(method = RequestMethod.GET, value = "/search", params="quantidade")
    public ResponseEntity<List<Car>>  getCarByQuantidade(@RequestParam("quantidade") Integer quantidade) {
        return new ResponseEntity<List<Car>> (carService.getByQuantidade(quantidade), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/search", params="marca")
    public ResponseEntity<List<Car>>  getCarMarca(@RequestParam("marca") String marca) {
        return new ResponseEntity<List<Car>> (carService.getByMarca(marca), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        return new ResponseEntity<Car>(carService.addCar(car.getNome(), car.getMarca(), car.getAnoFabricacao(), 
        		car.getAnoModelo(), car.getDataVenda()), HttpStatus.OK);
    } 
  
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") Integer id, @RequestBody Car car) {
        return new ResponseEntity<Car>(carService.updateCar(car.getId(), car.getNome(), car.getMarca(), car.getAnoFabricacao(), 
        		car.getAnoModelo(), car.getDataVenda()), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("id") Integer id) {
        if (carService.removeCar(id)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
 
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}
