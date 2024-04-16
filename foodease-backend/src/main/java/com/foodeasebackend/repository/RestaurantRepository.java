package com.foodeasebackend.repository;

import com.foodeasebackend.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    @Query("select r from Restaurant r where lower(r.name) Like lower(concat('%',:nameOrCuisineType,'%'))" +
            "or lower(r.cuisineType) Like lower(concat('%',:nameOrCuisineType,'%'))")
    List<Restaurant> searchRestaurantByNameOrCuisineType(String nameOrCuisineType);

    Restaurant findRestaurantByOwnerId(long ownerId);
}
