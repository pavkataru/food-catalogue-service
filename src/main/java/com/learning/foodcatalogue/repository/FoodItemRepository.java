package com.learning.foodcatalogue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.foodcatalogue.entity.FoodItem;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Integer>{

	List<FoodItem> findByRestaurantId(Integer restaurantId);
	
	

}
