package com.transportation.microservice.Dao;

import com.transportation.microservice.Model.Truck;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends MongoRepository<Truck, Integer> {

}
