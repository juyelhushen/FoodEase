package com.foodeasebackend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.foodeasebackend.dto.RestaurantDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User extends BaseEntity {

    private String fullName;

    @Email(message = "Please enter a correct email address", regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Order> orders = new CopyOnWriteArrayList<>();

    @ElementCollection
    private Set<RestaurantDto> favorites = new CopyOnWriteArraySet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> address = new CopyOnWriteArrayList<>();

    public void addOrRemoveFavorite(RestaurantDto dto) {
        boolean isFav = false;
        Set<RestaurantDto> favorites = getFavorites();
        for (RestaurantDto favorite : favorites) {
            if (favorite.getId() == dto.getId()) {
                isFav = true;
                break;
            }
        }
        if(isFav) favorites.removeIf(fav -> fav.getId() == dto.getId());
        else favorites.add(dto);
    }

}
