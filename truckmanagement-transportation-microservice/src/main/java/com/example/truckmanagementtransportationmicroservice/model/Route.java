package com.example.truckmanagementtransportationmicroservice.model;


import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import sun.security.krb5.internal.crypto.Des;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@CrossOrigin()
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalDate endTime;
    private Destination From;
    private Destination To;
    private Status status;


}
