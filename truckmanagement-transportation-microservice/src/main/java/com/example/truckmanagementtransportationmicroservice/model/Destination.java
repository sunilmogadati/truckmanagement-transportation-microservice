package com.example.truckmanagementtransportationmicroservice.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data

public class Destination {
    private Address address;
}
