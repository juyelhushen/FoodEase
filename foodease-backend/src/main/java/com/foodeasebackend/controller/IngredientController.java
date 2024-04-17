package com.foodeasebackend.controller;

import com.foodeasebackend.Entity.IngredientCategory;
import com.foodeasebackend.Entity.IngredientsItem;
import com.foodeasebackend.payload.IngredientCategoryRequest;
import com.foodeasebackend.payload.IngredientItemRequest;
import com.foodeasebackend.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredient")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService service;


    @PostMapping("/category/creted")
    public ResponseEntity<IngredientCategory> createCategory(
            @RequestBody IngredientCategoryRequest request) throws Exception {
        IngredientCategory category = service.
                createIngredientCategory(request.getName(), request.getRestaurantId());
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PostMapping("/item/created")
    public ResponseEntity<IngredientsItem> createIngredientItem(
            @RequestBody IngredientItemRequest request) throws Exception {
        IngredientsItem item = service.createIngredientItem(request.getRestaurantId(),
                request.getName(), request.getCategoryId());
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PutMapping("/stock/{id}")
    public ResponseEntity<IngredientsItem> updateStock(@PathVariable Long id) throws Exception {
        IngredientsItem item = service.updateStock(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<IngredientCategory>> getRestaurantIngredientCategory(
            @PathVariable Long restaurantId) {
        List<IngredientCategory> list = service.findIngredientCategoriesByRestaurantId(restaurantId);
        return ResponseEntity.ok(list);
    }


    @GetMapping("/items/{restaurantId}")
    public ResponseEntity<List<IngredientsItem>> getRestaurantIngredientItem(
            @PathVariable Long restaurantId) {
        List<IngredientsItem> list = service.getIngredientItemsByRestaurantId(restaurantId);
        return ResponseEntity.ok(list);
    }

}
