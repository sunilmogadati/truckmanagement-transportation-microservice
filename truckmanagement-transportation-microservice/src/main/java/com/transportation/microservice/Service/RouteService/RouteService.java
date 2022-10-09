package com.transportation.microservice.Service.RouteService;

import com.transportation.microservice.Dao.RouteRepository;
import com.transportation.microservice.Model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService implements RouteServiceInterface  {

    @Autowired
    RouteRepository routerepo;



    @Override
    public ResponseEntity<Route> getRouteById(long id) {
        Optional<Route> routeData = routerepo.findById(id);
        if(routeData.isPresent()){
            return new ResponseEntity<>(routeData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<Route>(HttpStatus.NOT_FOUND);
        }
    }



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
        return routerepo.save(route);
    }


//    @Override
//    public ResponseEntity<Route> getRouteDestination(String destination) {
//        Optional<Route>
//    }
//
//    @Override
//    public ResponseEntity<Route> getStartPoint(String start) {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<Route> getRouteStatusById(int id) {
//        return null;
//    }
}
