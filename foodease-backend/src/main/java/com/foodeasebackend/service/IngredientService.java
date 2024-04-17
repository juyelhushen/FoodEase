package com.foodeasebackend.service;

import com.foodeasebackend.Entity.IngredientCategory;
import com.foodeasebackend.Entity.IngredientsItem;

import java.util.List;

public interface IngredientService {

    public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception;

    public IngredientCategory findIngredientCategoryById(Long id) throws Exception;

    public List<IngredientCategory> findIngredientCategoriesByRestaurantId(Long restaurantId);

    public IngredientsItem createIngredientItem(Long restaurantId, String name, Long categoryId) throws Exception;

    public List<IngredientsItem> getIngredientItemsByRestaurantId(Long restaurantId);

    public IngredientsItem updateStock(Long id) throws Exception;
}
