package com.transportation.microservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
public class Route {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private String startLocation;
  private String endLocation;
  private boolean completed;

}
