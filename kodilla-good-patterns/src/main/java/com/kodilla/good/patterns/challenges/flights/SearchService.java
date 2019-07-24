package com.kodilla.good.patterns.challenges.flights;

import java.util.List;
import java.util.stream.Collectors;

public class SearchService {

    public List<String> findFlightsFrom(String city, FlightsRepository flightsRepository) {
        return flightsRepository.getFlights().stream()
                .filter(flight -> flight.getDepartureCity().equals(city))
                .map(Flight::getArrivalCity)
                .collect(Collectors.toList());
    }

    public List<String> findFlightsTo(String city, FlightsRepository flightsRepository) {
        return flightsRepository.getFlights().stream()
                .filter(flight -> flight.getArrivalCity().equals(city))
                .map(Flight::getDepartureCity)
                .collect(Collectors.toList());
    }

    public List<String> findFlightsWithTransfer(String departureCity, String arrivalCity, FlightsRepository flightsRepository) {
        List<String> arrivalCities = findFlightsFrom(departureCity, flightsRepository);
        List<String> departureCities = findFlightsTo(arrivalCity, flightsRepository);
        return arrivalCities.stream()
                .filter(city -> departureCities.contains(city))
                .collect(Collectors.toList());
    }
}
