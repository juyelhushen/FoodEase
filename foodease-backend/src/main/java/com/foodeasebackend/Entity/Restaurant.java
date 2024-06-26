package com.foodeasebackend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Table(name = "restaurant")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Restaurant extends BaseEntity {

    private String name;

    @ManyToOne
    private User owner;

    private String about;
    private String cuisineType;

    @OneToOne
    private Address address;

    @Embedded
    private Contact contact;

    private String openingHours;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant", orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    @ElementCollection
    @Column(length = 1000)
    private List<String> images;

    private boolean isOpen;

    private LocalDateTime registrationDate;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Food> foods = new ArrayList<>();


    public void addFood(Food food) {
        foods.add(food);
    }

    public void removeFood(Food food) {
        foods.remove(food);
    }
}
