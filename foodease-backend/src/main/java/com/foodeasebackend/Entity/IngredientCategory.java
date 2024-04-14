package com.foodeasebackend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredient_category")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class IngredientCategory extends BaseEntity {
    private String name;

    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;

    @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
    List<IngredientsItem> ingredients = new ArrayList<>();
}
