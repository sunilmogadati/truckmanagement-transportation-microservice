package com.transportation.microservice.service;

import org.springframework.http.ResponseEntity;
import com.transportation.microservice.model.Route;
import com.transportation.microservice.model.Truck;

public class Services implements ServicesInterface {

  @Override
  public ResponseEntity<Truck> getTruckById(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ResponseEntity<Route> getRouteById(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ResponseEntity<Route> getRouteDestination(String destination) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ResponseEntity<Route> getStartPoint(String start) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ResponseEntity<Route> getRouteStatusById(int id) {
    // TODO Auto-generated method stub
    return null;
  }

}
