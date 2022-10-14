package com.transportation.microservice.Model;


import lombok.*;

import java.io.Serializable;


@Getter
@NoArgsConstructor

@ToString
public enum Status implements Serializable {
    INCOMPLETE,
    COMPLETED;

    public String getStatus() {
        return this.name();
    }
}
