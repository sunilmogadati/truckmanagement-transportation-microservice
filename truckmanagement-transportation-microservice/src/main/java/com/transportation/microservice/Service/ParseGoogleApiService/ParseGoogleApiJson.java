package com.transportation.microservice.Service.ParseGoogleApiService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component
public class ParseGoogleApiJson {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public  Map<String, String> parseJson(ResponseEntity<String> jsonBody) throws ParseException {
        Map<String, String> distanceMartixInfo = new HashMap<>();
        JSONParser jsonParser = new JSONParser();
        Object object;
        JSONObject ob = (JSONObject) jsonParser.parse(jsonBody.getBody().toString());
        System.out.println(jsonBody.getBody());
//        // Destination Address
        String destination_addresses = ob.get("destination_addresses").toString();

//        //Origin Address
        String origin_addresses = ob.get("origin_addresses").toString();

        JSONArray technology = (JSONArray) ob.get("rows");

        Iterator itr = technology.iterator();
        while (itr.hasNext()) {
            JSONObject onk = (JSONObject) itr.next();
            JSONArray arr = (JSONArray) onk.get("elements");


            Iterator itr2 = arr.iterator();
            while(itr2.hasNext()){
                logger.info("Looping through the Google Api Json to Extract Info needed: ");
                JSONObject dock = (JSONObject) itr2.next();
                JSONObject duration = (JSONObject) dock.get("duration");
                JSONObject distance = (JSONObject) dock.get("distance");
                distanceMartixInfo.put("Duration", (String) duration.get("text"));
                distanceMartixInfo.put("TotalMiles", (String) distance.get("text"));
            }
        }
        return distanceMartixInfo;

    }
}
