package com.foodeasebackend.service;

import com.foodeasebackend.Entity.Category;
import com.foodeasebackend.Entity.Food;
import com.foodeasebackend.Entity.Restaurant;
import com.foodeasebackend.payload.FoodRequest;

import java.util.List;

public interface FoodService {


    public Food createFood(FoodRequest request, Category category, Restaurant restaurant);
    void deleteFood(Long foodId) throws Exception;

    public List<Food> getAllFood(Long restaurantId, boolean isVeg, boolean isNonVeg,
                                 boolean isSeasoned,
                                 String category) throws Exception;

    public List<Food> searchFood(String keyword);

    public Food findFoodById(Long foodId) throws Exception;
    public Food changeAvailabilityStatus(Long foodId) throws Exception;
}