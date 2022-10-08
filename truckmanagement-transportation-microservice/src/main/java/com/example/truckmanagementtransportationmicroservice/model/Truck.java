package com.example.truckmanagementtransportationmicroservice.model;

import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Truck {

  @Id
  int id;
  String make;
  String model;
  int year;


}
