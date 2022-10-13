package com.transportation.microservice.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "route")

public class Route {
  @Id
  private String routeid;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate startDate;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate endDate;
  @Size(min = 20)
  @NotBlank(message = "Source shouldn't be Empty")
  private String source;
  @NotBlank(message = "Destination shouldn't be Empty")
  private String destination;
  private Status status;

  public Route(LocalDate startDate, LocalDate endDate, String startLocation, String endLocation, Status status) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.source = startLocation;
    this.destination = endLocation;
    this.status = status;
  }

  public void setRouteid(String routeid) {
    this.routeid = routeid;
  }

  public String getRouteid() {
    return routeid;
  }


}
