package com.transportation.microservice.Service.TruckService;

import com.transportation.microservice.Model.Truck;
import org.springframework.http.ResponseEntity;
public interface TruckServiceInterface {
    ResponseEntity<Truck> getTruckById(int id);
}
