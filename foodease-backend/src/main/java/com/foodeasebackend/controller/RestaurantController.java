package com.foodeasebackend.controller;

import com.foodeasebackend.Entity.Restaurant;
import com.foodeasebackend.Entity.User;
import com.foodeasebackend.dto.RestaurantDto;
import com.foodeasebackend.service.RestaurantService;
import com.foodeasebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final UserService userService;


    @GetMapping("/getall")
    public ResponseEntity<List<Restaurant>> getAllRestaurant() {
        List<Restaurant> restaurantList = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurantList);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Restaurant> getRestaurantByUserId(@PathVariable Long userId) throws Exception {
        Restaurant restaurant = restaurantService.getRestaurantByUserId(userId);
        return ResponseEntity.ok(restaurant);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurants(@RequestParam String keyword)  {
        List<Restaurant> restaurantList = restaurantService.searchRestaurants(keyword);
        return ResponseEntity.ok(restaurantList);
    }


    @PostMapping("/{userId}/add-fav/{restaurantId}")
    public ResponseEntity<RestaurantDto> addToFav(@PathVariable Long userId,
                                                  @PathVariable Long restaurantId) throws Exception {
        User user = userService.findByUserId(userId);
        RestaurantDto dto = restaurantService.addToFavorite(restaurantId, user);
        return ResponseEntity.ok(dto);
    }
}
