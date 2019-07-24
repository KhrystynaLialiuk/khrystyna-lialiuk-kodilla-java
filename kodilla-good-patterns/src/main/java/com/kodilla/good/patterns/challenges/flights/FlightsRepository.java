package com.kodilla.good.patterns.challenges.flights;

import java.util.HashSet;

public class FlightsRepository {
    private HashSet<Flight> flights = new HashSet<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public HashSet<Flight> getFlights() {
        return flights;
    }
}
