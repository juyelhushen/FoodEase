package com.foodeasebackend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
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
}
