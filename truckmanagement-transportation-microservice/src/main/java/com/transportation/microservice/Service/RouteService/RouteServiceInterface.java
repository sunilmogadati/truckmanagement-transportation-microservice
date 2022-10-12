package com.transportation.microservice.Service.RouteService;

import org.springframework.http.ResponseEntity;
import com.transportation.microservice.Model.Route;
import java.util.List;

public interface RouteServiceInterface {
  ResponseEntity<Route> getRouteById(String id);
  ResponseEntity<List<Route>> getListofRoute();
  Route addRoute(Route route);
  String deleteRoute(String id);
  String updateRoute(Route route);
  List<Route> getRouteByDestination(String destination);
  List<Route> getRouteBySource(String source);
  List<Route> getRouteByStatus(String status);
  List<Route> findRouteBySourceAndDestinationAndStatus(String source, String destination, String status);
  long getRouteDistance(String source, String destination);





}
