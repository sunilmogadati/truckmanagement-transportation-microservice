package com.transportation.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.transportation.microservice.model.Route;
import com.transportation.microservice.model.Truck;
import com.transportation.microservice.service.Services;

@RestController
public class Controller {

  @Autowired
  Services services;

  @GetMapping("/api/v1/transportation")
  public ResponseEntity<Truck> getTruckById(@RequestParam int id) {
    return services.getTruckById(id);
  }

  @GetMapping("/api/v1/transportation")
  public ResponseEntity<Route> getRouteById(@RequestParam int id) {
    return services.getRouteById(id);
  }

  @GetMapping("/api/v1/transportation/route/{destination}")
  public ResponseEntity<Route> getRouteDestination(
      @PathVariable("destination") String destination) {
    return services.getRouteDestination(destination);
  }

  @GetMapping("/api/v1/transportation/route/{start}")
  public ResponseEntity<Route> getStartPoint(@PathVariable("start") String start) {
    return services.getStartPoint(start);
  }

  @GetMapping("/api/v1/transportation/route")
  public ResponseEntity<Route> getRouteStatusById(@RequestParam int id) {
    return services.getRouteStatusById(id);
  }
}
