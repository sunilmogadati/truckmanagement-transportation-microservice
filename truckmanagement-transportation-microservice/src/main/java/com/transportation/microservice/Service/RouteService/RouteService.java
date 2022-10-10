package com.transportation.microservice.Service.RouteService;

import com.transportation.microservice.Dao.RouteRepository;
import com.transportation.microservice.Model.Route;
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

//    private static  final String GOOGLE_API_KEY = "AIzaSyBtgmohbR3cDFi5nhPT7QZJQJ3T38nqtH4";
//    OkHttpClient client = new OkHttpClient();










//    public void  getRouteDistance(String startLocation, String endLocation) throws IOException {
//        String url="https://maps.googleapis.com/maps/api/distancematrix/json?origins="+startLocation+"&destinations="+endLocation+"&key="+ GOOGLE_API_KEY;
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//        Response response = client.newCall(request).execute();
//        String k = response.body().string();
//        System.out.println(k);
//
//    }


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
