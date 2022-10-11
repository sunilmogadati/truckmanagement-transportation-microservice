package com.transportation.microservice.Service.RouteService;

import com.transportation.microservice.Dao.RouteRepository;
import com.transportation.microservice.Model.Route;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RouteService implements RouteServiceInterface  {

    @Autowired
    RouteRepository routerepo;

//    private static  final String GOOGLE_API_KEY = "";

    @Override
    public ResponseEntity<Route> getRouteById(String id) {
        Optional<Route> route = routerepo.findById(id);
        System.out.println(route.get());
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

       routeData.stream().forEach(System.out::println);
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
    public ResponseEntity<Route> deleteRoute(String id) {
        return null;
    }

    @Override
    public ResponseEntity<Route> updateRoute(Route route) {
        return null;
    }

    @Override
    public List<Route> getRouteByDestination(String destination) {
        return null;
    }

    @Override
    public List<Route> getRouteBySource(String source) {
        return null;
    }
    @Override
    public List<Route> getRouteByStatus(String status) {
        return null;
    }
    @Override
    public List<Route> searchFilter(String source, String destination, String status) {
        return null;
    }
    @Override
    public long getRouteDistance(String source, String destination) {
        return 0;
    }

}
