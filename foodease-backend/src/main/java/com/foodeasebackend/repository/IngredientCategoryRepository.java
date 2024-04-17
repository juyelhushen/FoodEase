package com.foodeasebackend.repository;

import com.foodeasebackend.Entity.IngredientCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientCategoryRepository extends JpaRepository<IngredientCategory, Long> {

    List<IngredientCategory> findIngredientCategoriesByRestaurantId(Long restaurantId);
}
