package com.transportation.microservice.Controller;

import com.transportation.microservice.Model.Route;
import com.transportation.microservice.Service.RouteService.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/transportation")
public class RouteController {


    @Autowired
    RouteService routeservices;


    @GetMapping()
    public ResponseEntity<List<Route>> getListofRoutes(){
        return routeservices.getListofRoute();
    }

    @PostMapping("/routes")
    public Route addRoute(@RequestBody Route route){
        return routeservices.addRoute(route);

    }

//    @GetMapping("/route/")
//    public ResponseEntity<Route> getRouteById(@RequestParam int id) {
//        return routeservices.getRouteById(id);
//    }
//
//    @GetMapping("/route/{destination}")
//    public ResponseEntity<Route> getRouteDestination(
//            @PathVariable("destination") String destination) {
//        return routeservices.getRouteDestination(destination);
//    }
//
//    @GetMapping("/route/{start}")
//    public ResponseEntity<Route> getStartPoint(@PathVariable("start") String start) {
//        return routeservices.getStartPoint(start);
//    }
//
//    @GetMapping("/route")
//    public ResponseEntity<Route> getRouteStatusById(@RequestParam int id) {
//        return routeservices.getRouteStatusById(id);
//    }



}
