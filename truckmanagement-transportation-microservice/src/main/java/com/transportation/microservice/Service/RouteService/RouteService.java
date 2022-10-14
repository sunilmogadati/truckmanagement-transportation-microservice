
package com.transportation.microservice.Service.RouteService;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.transportation.microservice.Dao.RouteRepository;
import com.transportation.microservice.Model.Route;

import com.transportation.microservice.Service.ParseGoogleApiService.ParseGoogleApiJson;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class RouteService implements RouteServiceInterface  {

    Logger logger = LoggerFactory.getLogger(RouteService.class);
    @Value("${google-api}")
    private  String API_KEY;
    @Autowired
    RouteRepository routerepo;

    @Autowired
    ParseGoogleApiJson parseGoogleApiJson;



    public RouteService(ParseGoogleApiJson parseGoogleApiJson) {
        this.parseGoogleApiJson = parseGoogleApiJson;
    }

    @Override
    public ResponseEntity<Route> getRouteById(String id) {
        Optional<Route> route = routerepo.findById(id);
        if (route.isPresent()) {
            logger.info("Route found");
            return new ResponseEntity<>(route.get(), HttpStatus.FOUND);
        } else {
            logger.error("Route not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * This <Method Returns ReposeEntity of List of Routes
     * Checks the Size of routeData if size is less than 1 : returns HttoStatus
     * Not_Found
     *
     * @return ReposeEntity of List of Routes
     */

    @Override
    public ResponseEntity<List<Route>> getListofRoute() {
        List<Route> routeData = routerepo.findAll();
        if (routeData.size() >= 1) {
            logger.info("Route found");
            return new ResponseEntity<>(routeData, HttpStatus.OK);
        } else {
            logger.info("Route not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Route addRoute(Route route) {
        route.setRouteid(UUID.randomUUID().toString().split("_")[0]);
        System.out.println(route);
        logger.info("Route successfully added");
        return routerepo.save(route);
    }

    @Override
    public String deleteRoute(String id) {
        Optional<Route> route = routerepo.findById(id);
        if (route.isPresent()) {
            Route route1 = route.get();
            routerepo.delete(route1);
            logger.info("Route deleted");
            return "Route deleted: " + new ResponseEntity<>(route.get(), HttpStatus.OK)
                    .getBody()
                    .toString();
        } else {
            logger.error("Route could not be deleted");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND).getStatusCode().toString();
        }
    }

    @Override
    public String updateRoute(Route route) {
        logger.info("Updating Route.....");
        Optional<Route> routes = routerepo.findById(route.getRouteid()); // Check if route id exists
        if (routes.isPresent()) {
            routerepo.save(route); // Save the routes
            logger.info("Route updated successfully");
            return "Route update : " + new ResponseEntity<>(routes.get(), HttpStatus.OK)
                    .getBody()
                    .toString(); // Return Route information that was Updated
        } else {
            logger.error("Route could not be updated");
            return "Routeid is not available" +
                    new ResponseEntity<>(routes.get(), HttpStatus.NOT_FOUND).getBody().toString();
        }

    }

    @Override
    public List<Route> getRouteByDestination(String endLocation) {
        return routerepo.getByDestination(endLocation);

    }

    @Override
    public List<Route> getRouteBySource(String source) {
        return routerepo.getBySource(source);
    }

    @Override
    public List<Route> getRouteByStatus(String status) {
        return routerepo.findByStatus(status);
    }

    @Override
    public List<Route> findRouteBySourceAndDestinationAndStatus(String source, String destination, String status) {
        return routerepo.findRouteBySourceAndDestinationAndStatus(source, destination, status);
    }

    @Override
    public Map<String, String> calculateDistanceMatrix(String source, String destination) throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl="https://maps.googleapis.com/maps/api/distancematrix/json?origins="+source+"&destinations="+destination+ "&units=imperial" + "&key="+ API_KEY;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        Map<String , String > distanceMatrixInfo = parseGoogleApiJson.parseJson(response);

        return distanceMatrixInfo;

    }



}
