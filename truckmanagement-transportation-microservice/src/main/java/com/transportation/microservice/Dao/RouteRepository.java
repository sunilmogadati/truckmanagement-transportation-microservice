package com.transportation.microservice.Dao;

import com.transportation.microservice.Model.Route;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends MongoRepository<Route, String> {

    List<Route> findByStatus(String status);
    List<Route> getByDestination(String destination);
    List<Route> getBySource(String source);
    List<Route> findRouteBySourceAndDestinationAndStatus(String source, String destination, String status);
    List<Route> getByTruckId(int truckId);


}
