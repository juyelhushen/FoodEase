package com.foodeasebackend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cartegory")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Category extends BaseEntity {
    private String name;

    @ManyToOne
    @JsonIgnore
    private Restaurant restaurant;
}
