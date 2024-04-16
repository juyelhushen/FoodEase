package com.foodeasebackend.service;

import com.foodeasebackend.Entity.Address;
import com.foodeasebackend.Entity.Restaurant;
import com.foodeasebackend.Entity.User;
import com.foodeasebackend.dto.RestaurantDto;
import com.foodeasebackend.payload.RestaurantRequest;
import com.foodeasebackend.repository.AddressRepository;
import com.foodeasebackend.repository.RestaurantRepository;
import com.foodeasebackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    @Override
    public Restaurant createRestaurant(RestaurantRequest request, User user) {
        Address address = addressRepository.save(request.getAddress());
        Restaurant restaurant = Restaurant.builder()
                .name(request.getName())
                .about(request.getAbout())
                .address(address)
                .cuisineType(request.getCuisineType())
                .contact(request.getContact())
                .openingHours(request.getOpeningHours())
                .isOpen(true)
                .owner(user)
                .images(request.getImages())
                .registrationDate(LocalDateTime.now()).build();
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Long id, RestaurantRequest request) throws Exception {
        Restaurant restaurant = getRestaurantById(id);
        if (restaurant.getName() != null) restaurant.setName(request.getName());
        if (restaurant.getCuisineType() != null) restaurant.setCuisineType(request.getCuisineType());
        if (restaurant.getAbout() != null) restaurant.setAbout(request.getAbout());
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) throws Exception {
        Restaurant restaurant = getRestaurantById(restaurantId);
        restaurantRepository.delete(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> searchRestaurants(String nameOrCuisineType) {
        return restaurantRepository.searchRestaurantByNameOrCuisineType(nameOrCuisineType);
    }

    @Override
    public Restaurant getRestaurantById(Long id) throws Exception {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if (restaurant.isPresent()) {
            return restaurant.get();
        }
        throw new Exception("Restaurant not found with the id " + id);
    }

    @Override
    public Restaurant getRestaurantByUserId(Long userId) throws Exception {
        Restaurant restaurant = restaurantRepository.findRestaurantByOwnerId(userId);
        if (restaurant == null) throw new Exception("Restaurant not found with the user id " + userId);
        return restaurant;
    }

    @Override
    public RestaurantDto addToFavorite(Long restaurantId, User user) throws Exception {
        Restaurant restaurant = getRestaurantById(restaurantId);
        RestaurantDto dto = new RestaurantDto();
        dto.setId(restaurantId);
        dto.setTitle(restaurant.getName());
        dto.setDescription(restaurant.getAbout());
        dto.setImages(restaurant.getImages());

        if (user.getFavorites().contains(dto)) user.getFavorites().remove(dto);
        else user.getFavorites().add(dto);

        userRepository.save(user);
        return dto;
    }

    @Override
    public Restaurant updateRestaurantStatus(Long id) throws Exception {
        Restaurant restaurant = getRestaurantById(id);
        restaurant.setOpen(!restaurant.isOpen());
        restaurantRepository.save(restaurant);
        return restaurant;
    }
}
