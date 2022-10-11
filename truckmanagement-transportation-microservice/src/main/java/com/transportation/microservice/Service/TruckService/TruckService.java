package com.transportation.microservice.Service.TruckService;


import com.transportation.microservice.Dao.TruckRepository;
import com.transportation.microservice.Model.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TruckService implements TruckServiceInterface {

    @Autowired
    TruckRepository truckRepo;

    @Override
    public ResponseEntity<Truck> getTruckById(int id) {
        return null;
    }
}
