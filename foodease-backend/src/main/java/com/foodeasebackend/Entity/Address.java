package com.foodeasebackend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Address extends BaseEntity{

    private String streetAddress;
    private String city;
    private String stateProvince;
    private String postalCode;
    private String country;


}
