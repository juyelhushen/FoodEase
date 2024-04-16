package com.foodeasebackend.payload;

import com.foodeasebackend.Entity.Category;
import com.foodeasebackend.Entity.IngredientsItem;
import com.foodeasebackend.Entity.Restaurant;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FoodRequest {

    private String name;
    private String description;
    private double price;

    private Category category;
    private List<String> images;
    private Long restaurantId;
    private boolean isVegetarian;
    private boolean isSeasoned;

    private List<IngredientsItem> ingredientsItems;
}
