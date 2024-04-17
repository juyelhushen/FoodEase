package com.foodeasebackend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "category")
@Builder
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
