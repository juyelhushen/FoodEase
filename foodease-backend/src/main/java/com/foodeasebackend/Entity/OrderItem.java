package com.foodeasebackend.Entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "order_items")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderItem extends BaseEntity {

    @ManyToOne
    private Food foods;
    private int quantity;
    private double totalPrice;

    @ElementCollection
    private List<String> ingredients;
}
