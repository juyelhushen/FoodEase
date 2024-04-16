package com.foodeasebackend.repository;

import com.foodeasebackend.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food,Long> {
    Food findByRestaurantId(Long restaurantId);

    @Query("select f from Food f where f.name like %:keyword% or f.category.name like %:keyword%")
    List<Food> searchFood(@Param("keyword") String keyword);
}
