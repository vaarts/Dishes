package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.domain.DishesDomain;
import com.example.repository.DishesEntity;
import com.example.repository.DishesRepository;

@Service
public class DishesService {

	@Autowired
	private DishesRepository dishesRepository;
	
//	@Autowired
//	private DishesDomain dishesDomain;
	
	
	public DishesEntity save(DishesDomain dishesD) {
		DishesEntity dishedEntity = new DishesEntity(dishesD.getId(), dishesD.getName(), dishesD.getType(), dishesD.getIngredients().toString());
		return dishesRepository.save(dishedEntity);
	}
	
	public Iterable<DishesEntity> list(){
		return dishesRepository.findAll();
		
	}
	
	
	public DishesEntity findByDishName(String value) {
		List<DishesEntity> dishList = (List<DishesEntity>) dishesRepository.findAll();
		
		Optional<DishesEntity> dishByName = dishList.stream().filter(f -> f.getName().equalsIgnoreCase(value)).findFirst();
		
		if(dishByName.isPresent()) {
			return dishByName.get() ;
		}else {
			return null;
		}
		
	}
	
	public List<DishesEntity> find(String value) {
		List<DishesEntity> dishList = (List<DishesEntity>) dishesRepository.findAll();
		List<DishesEntity> dishByName = dishList.stream().filter(f -> f.getName().equalsIgnoreCase(value)).collect(Collectors.toList());
		List<DishesEntity> dishByType = dishList.stream().filter(f -> f.getType().equalsIgnoreCase(value)).collect(Collectors.toList());
		
		if(!CollectionUtils.isEmpty(dishByName)) {
			return dishByName;
		}else if(!CollectionUtils.isEmpty(dishByType)) {
			return dishByType ;
		}else {
			return null;
		}
		
	}
	
//	public void save(DishesEntity dishes){
//		DishesDomain dishesD = new DishesDomain(dishes.get, null, null, null)
//		dishesRepository.save(dishes);
//	}
	
}
