package com.transportation.microservice.test;

import com.transportation.microservice.Dao.RouteRepository;
import com.transportation.microservice.Model.Route;
import com.transportation.microservice.Model.Status;
import com.transportation.microservice.Service.RouteService.RouteService;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;


@SpringBootTest
class TruckManagementTransportationMicroserviceApplicationTests {

    @Autowired
    private RouteService routeService;
    @MockBean
    private RouteRepository routeRepo;
    @Test
    public void getListofRouteTest(){
//       RouteRepository mock = org.mockito.Mockito.mock(RouteRepository.class);
        when(routeRepo.findAll()).thenReturn(
                Stream.of( new Route(UUID.randomUUID().toString().split("_")[0],
                        LocalDate.of(2021, 01,01),
                        LocalDate.of(2022, 12,1),
                        "40 Griffin Ave. \n" +
                                "The Villages, FL 32162",
                        "87 South Newport Drive \n" +
                                "Lorain, OH 44052",
                        Status.IN_PROGRESS, 0 ), new Route(UUID.randomUUID().toString().split("_")[0],
                        LocalDate.of(2021, 01,01),
                        LocalDate.of(2022, 12,1),
                        "87 South Newport Drive \n" +
                                "Lorain, OH 44052",
                        "8588 Bridgeton Court \n" +
                                "Goldsboro, NC 27530",
                        Status.COMPLETED , 1)).collect(Collectors.toList()));
        assertEquals("Same", routeService.getListofRoute().getBody().size(), 2);
    }
    @Test
    public void getRouteIdTest() {
       String id = "1503bbf7-ee50-4d4a-bd70-d9880902cf7d";
       Route route = new Route(UUID.randomUUID().toString().split("_")[0],
               LocalDate.of(2021, 01,01),
               LocalDate.of(2022, 12,1),
               "40 Griffin Ave. \n" +
                       "The Villages, FL 32162",
               "87 South Newport Drive \n" +
                       "Lorain, OH 44052",
               Status.IN_PROGRESS, 1 );
       when(routeRepo.findById(id)).thenReturn(Optional.of(route));

       assertEquals("", routeService.getRouteById(id).getBody().getRouteId(), route.getRouteId());
    }
    @Test
    public void addRouteTest(){
        Route route = new Route(UUID.randomUUID().toString().split("_")[0],
                LocalDate.of(2021, 01,01),
                LocalDate.of(2022, 12,1),
                "40 Griffin Ave. \n" +
                        "The Villages, FL 32162",
                "87 South Newport Drive \n" +
                        "Lorain, OH 44052",
                Status.IN_PROGRESS, 1 );
        when(routeRepo.save(route)).thenReturn(route);
        ResponseEntity<Route> routeResponseEntity = routeService.addRoute(route);
        String truck_id = routeResponseEntity.getBody().getRouteId();
        assertEquals("Saved Route", route.getRouteId(),  truck_id);
    }

    @Test

    public void deleteRouteTest(){
        String id = "1503bbf7-ee50-4d4a-bd70-d9880902cf7d";
        List<Route> routes = Arrays.asList(
             new Route("1503bbf7-ee50-4d4a-bd70-d9880902cf7d",
                        LocalDate.of(2021, 01,01),
                        LocalDate.of(2022, 12,1),
                        "40 Griffin Ave. \n" +
                                "The Villages, FL 32162",
                        "87 South Newport Drive \n" +
                                "Lorain, OH 44052",
                        Status.IN_PROGRESS, 0 ),
                new Route("1903bbf7-ee50-4d4a-bd70-d9880902cfsd",
                        LocalDate.of(2021, 01,01),
                        LocalDate.of(2022, 12,1),
                        "87 South Newport Drive \n" +
                                "Lorain, OH 44052",
                        "8588 Bridgeton Court \n" +
                                "Goldsboro, NC 27530",
                        Status.COMPLETED, 1  ));


    }



    @Test
    void contextLoads() {


    }
}
