package com.transportation.microservice.Service.RouteService;

import org.springframework.http.ResponseEntity;
import com.transportation.microservice.Model.Route;

import java.util.List;
import java.util.Optional;

public interface RouteServiceInterface {



  ResponseEntity<Route> getRouteById(String id);

  ResponseEntity<List<Route>> getListofRoute();

  Route addRoute(Route route);


//  ResponseEntity<Route> getRouteById(long id);
//
//  ResponseEntity<Route> getRouteDestination(String destination);
//  ResponseEntity<Route> getStartPoint(String start);
//  ResponseEntity<Route> getRouteStatusById(int id);
}
