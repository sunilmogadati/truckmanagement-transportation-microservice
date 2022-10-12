


package com.transportation.microservice.Service.RouteService;

import com.transportation.microservice.Dao.RouteRepository;
import com.transportation.microservice.Model.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class RouteService implements RouteServiceInterface  {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    RouteRepository routerepo;
    @Override
    public ResponseEntity<Route> getRouteById(String id) {
        Optional<Route> route = routerepo.findById(id);
        if(route.isPresent()){
            return new ResponseEntity<>(route.get(), HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * This <Method Returns ReposeEntity of List of Routes
     * Checks the Size of routeData if size is less than 1 : returns HttoStatus Not_Found
     *
     * @return ReposeEntity of List of Routes
     */

    @Override
    public ResponseEntity<List<Route>> getListofRoute() {
        List<Route> routeData = routerepo.findAll();
        if(routeData.size() > 1){
            return new ResponseEntity<>(routeData, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public Route addRoute(Route route) {
        route.setRouteid(UUID.randomUUID().toString().split("_")[0]);
        System.out.println(route);
        return routerepo.save(route);
    }

    @Override
    public String deleteRoute(String id) {
        Optional<Route> route = routerepo.findById(id);

        if(route.isPresent()){
            Route route1 = route.get();
            routerepo.delete(route1);
            return "Route deleted: " + new ResponseEntity<>(route.get(), HttpStatus.OK)
                    .getBody()
                    .toString();
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND).getStatusCode().toString();
        }
    }

    @Override
    public String updateRoute(Route route) {
        logger.info("Updating Route.....");
        Optional<Route> routes = routerepo.findById(route.getRouteid()); // Check if route id exists
        if(routes.isPresent()){
            routerepo.save(route); // Save the routes
            return "Route update : " + new ResponseEntity<>(routes.get(), HttpStatus.OK)
                    .getBody()
                    .toString(); // Return Route information that was Updated
        }else{
            return "Routeid is not available" +
                    new ResponseEntity<>(routes.get(), HttpStatus.NOT_FOUND).getBody().toString() ;
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
    public long getRouteDistance(String source, String destination) {
        return 0;
    }

}










