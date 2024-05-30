package com.learning.foodcatalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learning.foodcatalogue.dto.FoodCataloguePage;
import com.learning.foodcatalogue.dto.Restaurant;
import com.learning.foodcatalogue.entity.FoodItem;
import com.learning.foodcatalogue.repository.FoodItemRepository;

@Service
public class FoodCatalogueService {
	
	
    @Autowired    
	FoodItemRepository foodItemRepo;
    
    @Autowired
    RestTemplate restTemplate;

	public FoodItem addFoodItem(FoodItem foodItem) {
		
		
		// TODO Auto-generated method stub
		return foodItemRepo.save(foodItem);
	}

	public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {
		// TODO Auto-generated method stub
		//food item list
		//restaurant details
		
		List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
		Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
		return createFoodCataloguePage(foodItemList,restaurant);
	}

	private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
		
		FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
		foodCataloguePage.setFoodItemList(foodItemList);
		foodCataloguePage.setRestaurant(restaurant);
		return foodCataloguePage;
		
	}

	private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
		
		return restTemplate.getForObject("http://localhost:7081/restaurant/fetchRestaurantById/"+restaurantId,Restaurant.class);
	
	}

	private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
		// TODO Auto-generated method stub
		return foodItemRepo.findByRestaurantId(restaurantId);
		
	}
	
}
