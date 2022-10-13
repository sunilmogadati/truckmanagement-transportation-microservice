package com.transportation.microservice.Controller;

import com.transportation.microservice.Model.Route;
import com.transportation.microservice.Service.RouteService.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@RequestMapping("/api/vi/transportation")
public class RouteController {

    Logger logger = LoggerFactory.getLogger(RouteController.class);

    @Autowired
    RouteService routeservices;

    @GetMapping("/route")
    @CrossOrigin()
    public ResponseEntity<List<Route>> getListofRoutes() {
        logger.info("Getting list of routes");
        return routeservices.getListofRoute();
    }

    @GetMapping("/route/{id}")
    @CrossOrigin()
    public ResponseEntity<Route> getListofRoutes(@PathVariable String id) {
        logger.info("Getting list of routes by ID");
        return routeservices.getRouteById(id);
    }

    @PostMapping("/route")
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin()
    public Route addRoute(@RequestBody Route route) {
        logger.info("Adding route");
        return routeservices.addRoute(route);

    }

    @DeleteMapping("/route/{id}")
    @CrossOrigin()
    public String deleteRoute(@PathVariable String id) {
        logger.info("Removing route");
        return routeservices.deleteRoute(id);
    }

    @PostMapping("/route/update")
    @CrossOrigin()
    public String updateRoute(@RequestBody Route route) {
        //
        logger.info("Updating route");
        return routeservices.updateRoute(route);
    }

    @GetMapping("/route/destination")
    @CrossOrigin()
    // localhost:8080/api/vi/transportation/route/destination?destination=87 South
    // Newport Drive Lorain, OH 44052
    public List<Route> getRouteByDestination(@RequestParam String destination) {
        logger.info("Getting routes by destination");
        return routeservices.getRouteByDestination(destination);
    }

    @GetMapping("/route/status")
    @CrossOrigin()
    // localhost:8080/api/vi/transportation/route/status?status=INCOMPLETE
    public List<Route> findByStatus(@RequestParam String status) {

        //
        logger.info("Getting routes by status");
        return routeservices.getRouteByStatus(status);
    }

    @GetMapping("/route/source")
    @CrossOrigin()
    // localhost:8080/api/vi/transportation/route/source?source=80 Griffin Ave The
    // Villages, FL 32162
    public List<Route> getRouteBySource(@RequestParam String source) {
        logger.info("Getting route by source");
        return routeservices.getRouteBySource(source);
    }

    @GetMapping("/route/filter")
    @CrossOrigin()
    // localhost:8080/api/vi/transportation/route/filter?source=2450 Griffin Ave The
    // Villages, FL 32162&destination=9314 South Newport Drive Lorain, OH
    // 44052&status=COMPLETED
    public List<Route> findRouteBySourceAndDestinationAndStatus(@RequestParam String source,
            @RequestParam String destination,
            @RequestParam String status) {
        logger.info("Getting routes by filter");
        return routeservices.findRouteBySourceAndDestinationAndStatus(source, destination, status);

    }

}