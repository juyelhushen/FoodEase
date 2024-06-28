package com.foodeasebackend.controller;

import com.foodeasebackend.Entity.Food;
import com.foodeasebackend.Entity.Restaurant;
import com.foodeasebackend.payload.FoodRequest;
import com.foodeasebackend.service.FoodService;
import com.foodeasebackend.service.RestaurantService;
import com.foodeasebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/food")
@RequiredArgsConstructor
public class AdminFoodController {

    private final FoodService foodService;
    private final UserService userService;
    private final RestaurantService restaurantService;

    @PostMapping("/created")
    public ResponseEntity<Food> created(@RequestBody FoodRequest request) throws Exception {
        Restaurant restaurant = restaurantService.getRestaurantById(request.getRestaurantId());
        Food food = foodService.createFood(request,request.getCategory(),restaurant);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable Long id) throws Exception {
        foodService.deleteFood(id);
        return new ResponseEntity<>("Food deleted", HttpStatus.ACCEPTED);
    }

    @PostMapping("/status/{id}")
    public ResponseEntity<Food> changeStatus(@PathVariable Long id) throws Exception {
        Food food = foodService.changeAvailabilityStatus(id);
        return ResponseEntity.ok(food);
    }

    
}
