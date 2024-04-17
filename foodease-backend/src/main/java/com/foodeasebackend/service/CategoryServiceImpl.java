package com.foodeasebackend.service;

import com.foodeasebackend.Entity.Category;
import com.foodeasebackend.Entity.Restaurant;
import com.foodeasebackend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final RestaurantService restaurantService;

    @Override
    public Category createCategory(String name, Long userId) throws Exception{
        Restaurant restaurant = restaurantService.getRestaurantByUserId(userId);
        Category category = Category.builder()
                .name(name)
                .restaurant(restaurant)
                .build();
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findCategoryByRestaurantId(Long restaurantId) throws Exception {
        return categoryRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public Category findCategoryById(Long categoryId) throws Exception {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isEmpty()) throw new Exception("Category not found: " + categoryId);
        return category.get();
    }
}
