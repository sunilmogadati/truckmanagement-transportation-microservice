package com.transportation.microservice.Service.RouteService;

import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import com.transportation.microservice.Model.Route;
import java.util.List;
import java.util.Map;

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
  Map<String, String> calculateDistanceMatrix(String source , String destination) throws ParseException;





}
