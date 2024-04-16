package com.foodeasebackend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "food")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Food extends BaseEntity {

    private String name;
    private String description;
    private double price;

    @ManyToOne
    private Category category;

    @Column(length = 1000)
    @ElementCollection
    private List<String> images;

    @ManyToOne
    private Restaurant restaurant;
    private boolean isAvailable;
    private boolean isNonVeg;
    private boolean isVegetarian;
    private boolean isSeasoned;

    @ManyToMany
    private List<IngredientsItem> ingredientsItems = new ArrayList<>();

    private LocalDate createdAt;
}
