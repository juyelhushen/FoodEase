package com.foodeasebackend.controller;

import com.foodeasebackend.Entity.Category;
import com.foodeasebackend.Entity.User;
import com.foodeasebackend.service.CategoryService;
import com.foodeasebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/category")
@RequiredArgsConstructor
public class AdminCategoryController {

    private final CategoryService categoryService;
    private final UserService userService;

    @PostMapping("/create/{userId}")
    public ResponseEntity<Category> createCategory(@RequestBody Category category,
                                                   @PathVariable Long userId) throws Exception {
        Category savedCategory = categoryService.createCategory(category.getName(), userId);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }


    @GetMapping("/restaurant/{restaurantId}/")
    public ResponseEntity<List<Category>> getByRestaurant(@PathVariable Long restaurantId)
            throws Exception {
        List<Category> categoryList = categoryService.findCategoryByRestaurantId(restaurantId);
        return ResponseEntity.ok(categoryList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> categoryById(@PathVariable Long id) throws Exception {
        Category category = categoryService.findCategoryById(id);
        return ResponseEntity.ok(category);
    }



}
