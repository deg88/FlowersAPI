package com.example.act1.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.act1.dto.FlowerDTO;
import com.example.act1.model.Flower;
import com.example.act1.repository.FlowerRepository;

@RestController
@RequestMapping("/api/v1")
public class FlowerController {

	@Autowired
	private FlowerRepository flowerRepository;
	
	//GetAll, envia una lista
	@GetMapping("/flower")
	public List<Flower> getFlowers () {
		return flowerRepository.findAll();
	}
	
	//Get, solo trae uno
	@GetMapping("/flowers/{idFlower}")
	public Flower getFlower (@PathVariable int idFlower) {
		Flower f = flowerRepository.getById(idFlower);
		return f;
	}
	
	//Post, adiciona 
	@PostMapping("/flower")
	public Flower saveFlower (@RequestBody Flower flower) {
		flowerRepository.save(flower);	
		return flower;
	}
	
	//PostList, toda una lista y quedan guardados
	@PostMapping("/flowers")
	public ResponseEntity<String> saveFlowers (@RequestBody List<FlowerDTO> flowersList) {
		
		for (FlowerDTO flower : flowersList) {
			flowerRepository.save(new Flower(flower));
		}
		return new ResponseEntity<String>("DONE", HttpStatus.CREATED);
	}
	
	//Put, modifica 
	@PutMapping("/flower/{idFlower}")
	public Flower putAuto(@PathVariable int idFlower, @RequestBody Flower flower){
		
		Flower f = flowerRepository.getById(idFlower);
		
		f.setPetalLength(flower.getPetalLength());
		f.setPetalWidth(flower.getPetalWidth());
		f.setSepalLength(flower.getSepalLength());
		f.setSepalWidth(flower.getSepalWidth());
		f.setSpecie(flower.getSpecie());
		
	
		flowerRepository.save(f);
		return f;
	}
	
	//Delete, eliminar
	@DeleteMapping("/flower/{idFlower}")
	public String delFlower(@PathVariable int idFlower){
		flowerRepository.deleteById(idFlower);
		return "Delete";
	}
	
	//Punto 2 Metodo de busqueda
	@GetMapping("/flowerlook/{l}")
	public List<Flower> getFlowersBySpecies(@PathVariable String l) {
		return flowerRepository.lookForLetter(l);
	}
	
	@GetMapping("/flowerlook/test/")
	public List<Flower> getFlowersBySpecies(@RequestParam(name = "min") Double min, @RequestParam(name = "max") Double max) {
		
		return flowerRepository.getByPetalLengthBetween(min, max);
	}
	
}
