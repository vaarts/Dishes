package com.example.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Service
@Repository
public interface DishesRepository extends CrudRepository<DishesEntity, Integer> {
	
//	@Query(nativeQuery = true, value="select * from ")

}
