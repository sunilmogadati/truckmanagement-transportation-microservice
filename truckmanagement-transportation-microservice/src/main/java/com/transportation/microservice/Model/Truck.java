package com.transportation.microservice.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "truck")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Truck {

    @Id
    private int id;
    private String make;
    private String model;
    private int year;


}
