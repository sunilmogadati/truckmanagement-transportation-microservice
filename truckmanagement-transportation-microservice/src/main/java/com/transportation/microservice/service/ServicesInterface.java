package com.transportation.microservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.util.RouteMatcher.Route;
import com.transportation.microservice.model.Truck;

public interface ServicesInterface {
  ResponseEntity<Truck> getTruckById(int id);

  ResponseEntity<Route> getRouteById(int id);

  ResponseEntity<Route> getRouteDestination(String destination);

  ResponseEntity<Route> getStartPoint(String start);

  ResponseEntity<Route> getRouteStatusById(int id);
}
