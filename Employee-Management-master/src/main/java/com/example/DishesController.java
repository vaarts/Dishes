package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.DishesDomain;
import com.example.repository.DishesEntity;
import com.example.repository.DishesRepository;
import com.example.service.DishesService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/dishes")
public class DishesController {

	@Autowired
	DishesRepository dishesRepository;
	
	@Autowired
	DishesService dishesService;
	
	
	@GetMapping("/get/all")
	public List<DishesEntity> getDishesDomains() {
		return (List<DishesEntity>) dishesRepository.findAll();
	}

	@PostMapping("/add")
	public DishesEntity addDishes(@RequestBody DishesDomain dishes) {
		return dishesService.save(dishes);
	}
	
	@PostMapping("/findByName/{value}")
	public DishesEntity findDish(@PathVariable String value) {
		return dishesService.findByDishName(value);
	}
	
	@PostMapping("find/{value}")
	public List<DishesEntity> find(@PathVariable String value){
		return dishesService.find(value);
	}
	

//		
//		@DeleteMapping("/delete_dishes/{id}")
//		public boolean deleteDishes (@PathVariable int id) {
//			try {
//				dishesRepository.deleteById(id);
//			return true;
//			}catch(Exception e) {
//				e.printStackTrace();
//				return false;
//			}
//		}
//	
//	@PutMapping("/update_dishes")
//			public DishesDomain updateDishes(@RequestBody DishesDomain dishesDomain) {
//				Optional<DishesDomain> dishes= dishesRepository.findById(dishesDomain.getId());
//				return (dishes.isPresent()) ? dishesRepository.save(dishesDomain):null; 
//				
//	}
}