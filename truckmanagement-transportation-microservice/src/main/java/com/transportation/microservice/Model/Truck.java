package com.transportation.microservice.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Truck {
    @Id
    private int id;
   @Field
    private String make;
    @Field
    private String model;
    @Field
    private int year;
    @Field
    private String weight;
    @Field
    private String volume;
    @Field
    private int mpg;
    @Field
    private String space;
    @Field
    private Type type;
}
