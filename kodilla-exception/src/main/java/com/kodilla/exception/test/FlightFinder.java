package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Warsaw", true);
        airports.put("Paris", true);
        airports.put("Kyiv", true);
        airports.put("Lviv", false);
        airports.put("Odesa", false);

        boolean flightFound = false;
        String flightFrom = flight.getDepartureAirport();
        String flightTo = flight.getArrivalAirport();
        if (airports.containsKey(flightFrom) && airports.containsKey(flightTo)){
            if (airports.get(flightFrom) && airports.get(flightTo)){
                flightFound = true;
            }
        } else {
            throw new RouteNotFoundException();
        }
        return flightFound;
    }
}
