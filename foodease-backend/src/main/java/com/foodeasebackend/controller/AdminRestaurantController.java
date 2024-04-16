package com.foodeasebackend.controller;

import com.foodeasebackend.Entity.Restaurant;
import com.foodeasebackend.Entity.User;
import com.foodeasebackend.payload.RestaurantRequest;
import com.foodeasebackend.service.RestaurantService;
import com.foodeasebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminRestaurantController {

    private final RestaurantService restaurantService;
    private final UserService userService;


    @PostMapping("/add/{userId}")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody RestaurantRequest request,
                                                    @PathVariable Long userId) throws Exception {
        User user = userService.findByUserId(userId);
        Restaurant restaurant = restaurantService.createRestaurant(request, user);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody RestaurantRequest request,
                                                       @PathVariable Long id) throws Exception {
        Restaurant restaurant = restaurantService.updateRestaurant(id,request);
        return new ResponseEntity<>(restaurant, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeleteRestaurant(@PathVariable Long id) throws Exception {
        restaurantService.deleteRestaurant(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.NO_CONTENT);
    }


    @PutMapping("/status/{id}")
    public ResponseEntity<Restaurant> changeRestaurantStatus(@PathVariable Long id) throws Exception {
        Restaurant restaurant = restaurantService.updateRestaurantStatus(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
}
