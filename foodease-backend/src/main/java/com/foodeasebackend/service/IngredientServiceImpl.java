package com.foodeasebackend.service;

import com.foodeasebackend.Entity.Category;
import com.foodeasebackend.Entity.IngredientCategory;
import com.foodeasebackend.Entity.IngredientsItem;
import com.foodeasebackend.Entity.Restaurant;
import com.foodeasebackend.repository.IngredientCategoryRepository;
import com.foodeasebackend.repository.IngredientItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientCategoryRepository ingredientCategoryRepository;
    private final IngredientItemRepository ingredientItemRepository;
    private final RestaurantService restaurantService;
    private final CategoryService categoryService;

    @Override
    public IngredientCategory createIngredientCategory(String name,
                                                       Long restaurantId) throws Exception {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        IngredientCategory ingredientCategory = new IngredientCategory();
        ingredientCategory.setName(name);
        ingredientCategory.setRestaurant(restaurant);

        return  ingredientCategoryRepository.save(ingredientCategory);
    }

    @Override
    public IngredientCategory findIngredientCategoryById(Long id) throws Exception {
        Optional<IngredientCategory> optionalCategory = ingredientCategoryRepository.findById(id);
        if (optionalCategory.isEmpty()) throw new Exception("IngredientCategory does not exist : " + id);
        return optionalCategory.get();
    }

    @Override
    public List<IngredientCategory> findIngredientCategoriesByRestaurantId(Long restaurantId) {
        return ingredientCategoryRepository.findIngredientCategoriesByRestaurantId(restaurantId);
    }

    @Override
    public IngredientsItem createIngredientItem(Long restaurantId,
                                                    String name,
                                                    Long categoryId) throws Exception {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        IngredientCategory ingredientCategory = findIngredientCategoryById(categoryId);

        IngredientsItem ingredientsItem = new IngredientsItem();
        ingredientsItem.setName(name);
        ingredientsItem.setRestaurant(restaurant);
        ingredientsItem.setCategory(ingredientCategory);
        IngredientsItem ingredients = ingredientItemRepository.save(ingredientsItem);
        ingredientCategory.getIngredients().add(ingredients);
        return ingredients;
    }

    @Override
    public List<IngredientsItem> getIngredientItemsByRestaurantId(Long restaurantId) {
        return ingredientItemRepository.findIngredientsItemByRestaurantId(restaurantId);
    }

    @Override
    public IngredientsItem updateStock(Long id) throws Exception {
        Optional<IngredientsItem> optional = ingredientItemRepository.findById(id);
        if (optional.isEmpty()) throw new Exception("Ingredient Item not found: " + id);
        IngredientsItem items = optional.get();
        items.setInStock(!items.isInStock());
        return ingredientItemRepository.save(items);
    }
}
