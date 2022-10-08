package com.transportation.microservice.model;

import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Route {

  @Id
  int id;
  LocalDateTime startDate;
  LocalDateTime endDate;
  String startLocation;
  String endLocation;
  boolean completed;
  
}
