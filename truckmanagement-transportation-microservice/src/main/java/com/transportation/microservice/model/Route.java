package com.transportation.microservice.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
