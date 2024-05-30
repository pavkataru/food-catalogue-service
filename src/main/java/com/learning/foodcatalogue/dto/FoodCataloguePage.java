package com.learning.foodcatalogue.dto;

import java.util.List;

import com.learning.foodcatalogue.entity.FoodItem;

public class FoodCataloguePage {
	
	public List<FoodItem> getFoodItemList() {
		return foodItemList;
	}
	public void setFoodItemList(List<FoodItem> foodItemList) {
		this.foodItemList = foodItemList;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	private List<FoodItem> foodItemList;
	private Restaurant restaurant;
	

}
