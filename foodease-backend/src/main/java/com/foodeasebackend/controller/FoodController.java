package com.foodeasebackend.controller;

import com.foodeasebackend.Entity.Food;
import com.foodeasebackend.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;


    @GetMapping("/getAll/{restaurantId}")
    public ResponseEntity<List<Food>> getAllFood(@PathVariable Long restaurantId,
                                                @RequestParam boolean isVeg,@RequestParam boolean isNonVeg,
                                                @RequestParam boolean isSeasoned, @RequestParam (required = false) String category) throws Exception {
        List<Food> foodList = foodService.getAllFood(restaurantId,isVeg,isNonVeg,isSeasoned,category);
        return ResponseEntity.ok(foodList);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Food>> searchFood(@RequestParam String keyword) throws Exception {
        List<Food> foodList = foodService.searchFood(keyword);
        return ResponseEntity.ok(foodList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable Long id) throws Exception {
        Food food = foodService.findFoodById(id);
        return ResponseEntity.ok(food);
    }
}
