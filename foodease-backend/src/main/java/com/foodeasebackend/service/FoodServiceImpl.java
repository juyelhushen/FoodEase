package com.foodeasebackend.service;

import com.foodeasebackend.Entity.Category;
import com.foodeasebackend.Entity.Food;
import com.foodeasebackend.Entity.Restaurant;
import com.foodeasebackend.payload.FoodRequest;
import com.foodeasebackend.repository.FoodRepository;
import com.foodeasebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private final UserRepository userRepository;

    @Override
    public Food createFood(FoodRequest request, Category category, Restaurant restaurant) {
        Food food = Food.builder()
                .name(request.getName())
                .price(request.getPrice())
                .description(request.getDescription())
                .category(category)
                .isSeasoned(request.isSeasoned())
                .isVegetarian(request.isVegetarian())
                .ingredientsItems(request.getIngredientsItems())
                .restaurant(restaurant)
                .images(request.getImages()).build();
        Food savedFood = foodRepository.save(food);
        restaurant.addFood(savedFood);
        return savedFood;
    }

    @Override
    public void deleteFood(Long foodId) throws Exception {
        Food food = findFoodById(foodId);
        food.getRestaurant().removeFood(food);
        foodRepository.delete(food);
    }

    @Override
    public List<Food> getAllFood(Long restaurantId, boolean isVeg,
                                 boolean isNonVeg, boolean isSeasoned,
                                 String category) {
        List<Food> foods = foodRepository.findAll();
        if (isVeg)  foods = filterByIsVeg(foods);
        if (isNonVeg)  foods = filterByNonVeg(foods);
        if (isSeasoned) foods = filterBySeasoned(foods);
        if (!Objects.isNull(category)) foods = filterByCategory(foods,category);
        return foods;
    }

    private List<Food> filterByCategory(List<Food> foods, String category) {
        return foods.stream().filter(food -> food.getCategory().getName().equals(category)).toList();
    }

    private List<Food> filterBySeasoned(List<Food> foods) {
        return foods.stream().filter(Food::isSeasoned).toList();
    }

    private List<Food> filterByNonVeg(List<Food> foods) {
        return foods.stream().filter(Food::isNonVeg).toList();
    }

    private List<Food> filterByIsVeg(List<Food> foods) {
        return foods.stream().filter(Food::isVegetarian).toList();
    }


    @Override
    public List<Food> searchFood(String keyword) {
        return foodRepository.searchFood(keyword);
    }

    @Override
    public Food findFoodById(Long foodId) throws Exception {
        Optional<Food> food = foodRepository.findById(foodId);
        if (food.isEmpty()) throw new Exception("Food not found: " + foodId);
        return food.get();
    }

    @Override
    public Food changeAvailabilityStatus(Long foodId) throws Exception {
        Food food = findFoodById(foodId);
        food.setAvailable(!food.isAvailable());
        return foodRepository.save(food);
    }
}
