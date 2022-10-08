package com.example.truckmanagementtransportationmicroservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String buildingNo;
    private String StreetName;
    private String city;
    private String state;
    @Size(min =00001 , max = 99950)
    private int Zipcode;
}
