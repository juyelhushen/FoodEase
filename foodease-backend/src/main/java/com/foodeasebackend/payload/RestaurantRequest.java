package com.foodeasebackend.payload;

import com.foodeasebackend.Entity.Address;
import com.foodeasebackend.Entity.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantRequest {
    private String name;
    private String about;
    private String cuisineType;
    private Address address;
    private Contact contact;
    private String openingHours;
    private List<String> images;
}
