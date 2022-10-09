package com.transportation.microservice.Service.RouteService;

import org.springframework.http.ResponseEntity;
import com.transportation.microservice.Model.Route;

import java.util.List;

public interface RouteServiceInterface {

  ResponseEntity<Route> getRouteById(long id);

  ResponseEntity<List<Route>> getListofRoute();

  Route addRoute(Route route);


//  ResponseEntity<Route> getRouteById(long id);
//
//  ResponseEntity<Route> getRouteDestination(String destination);
//  ResponseEntity<Route> getStartPoint(String start);
//  ResponseEntity<Route> getRouteStatusById(int id);
}
