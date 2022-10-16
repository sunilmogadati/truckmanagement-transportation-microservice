package com.transportation.microservice.Model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public enum Type {
    GAS, HYBRID, ELECTRIC;


    @Override
    public String toString() {
        return super.toString();
    }


}
