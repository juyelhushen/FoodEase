package com.foodeasebackend.service;

import com.foodeasebackend.Entity.Restaurant;
import com.foodeasebackend.Entity.User;
import com.foodeasebackend.dto.RestaurantDto;
import com.foodeasebackend.payload.RestaurantRequest;

import java.util.List;

public interface RestaurantService {

    public Restaurant createRestaurant(RestaurantRequest request, User user);

    public Restaurant updateRestaurant(Long id, RestaurantRequest request) throws Exception;

    public void deleteRestaurant(Long restaurantId) throws Exception;

    public List<Restaurant> getAllRestaurants();

    public List<Restaurant> searchRestaurants(String nameOrCuisineType);

    public Restaurant getRestaurantById(Long id) throws Exception;

    public Restaurant getRestaurantByUserId(Long userId) throws Exception;

    public RestaurantDto addToFavorite(Long restaurantId, User user) throws Exception;

    public Restaurant updateRestaurantStatus(Long id) throws Exception;
}
