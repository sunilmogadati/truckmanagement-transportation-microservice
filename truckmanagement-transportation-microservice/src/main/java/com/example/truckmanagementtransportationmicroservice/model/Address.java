package com.example.truckmanagementtransportationmicroservice.model;


import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Address {
    private String buildingNo;
    private String StreetName;
    private String city;
    private String state;
    @Size(min =00001 , max = 99950)
    private int Zipcode;
}
