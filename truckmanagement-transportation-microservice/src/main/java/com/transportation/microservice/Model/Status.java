package com.transportation.microservice.Model;


import lombok.*;

import java.io.Serializable;


@Getter
@NoArgsConstructor

@ToString
public enum Status implements Serializable {
    IN_PROGRESS,
    DELAYED,
    STARTED,
    COMPLETED,
    SCHEDULED;
    public String getStatus() {
        return this.name();
    }
}
