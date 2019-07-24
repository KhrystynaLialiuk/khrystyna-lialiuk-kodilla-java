package com.kodilla.good.patterns.challenges.flights;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SearchServiceTestSuite {
    @Test
    public void testFindFlightsFrom() {
        //Given
        FlightsRepository flightsRepository = new FlightsRepository();
        flightsRepository.addFlight(new Flight("Warsaw", "Lublin"));
        flightsRepository.addFlight(new Flight("Warsaw", "Wroclaw"));
        //When
        SearchService searchService = new SearchService();
        List<String> arrivalCities = searchService.findFlightsFrom("Warsaw", flightsRepository);
        //Then
        Assert.assertEquals(2, arrivalCities.size());
        Assert.assertTrue(arrivalCities.contains("Lublin"));
        Assert.assertTrue(arrivalCities.contains("Wroclaw"));
    }
    @Test
    public void testFindFlightsFromNotFound() {
        //Given
        FlightsRepository flightsRepository = new FlightsRepository();
        flightsRepository.addFlight(new Flight("Warsaw", "Lublin"));
        //When
        SearchService searchService = new SearchService();
        List<String> arrivalCities = searchService.findFlightsFrom("Lublin", flightsRepository);
        //Then
        Assert.assertEquals(0, arrivalCities.size());
    }

    @Test
    public void testFindFlightsTo() {
        //Given
        FlightsRepository flightsRepository = new FlightsRepository();
        flightsRepository.addFlight(new Flight("Warsaw", "Lublin"));
        flightsRepository.addFlight(new Flight("Wroclaw", "Lublin"));
        //When
        SearchService searchService = new SearchService();
        List<String> departureCities = searchService.findFlightsTo("Lublin", flightsRepository);
        //Then
        Assert.assertEquals(2, departureCities.size());
        Assert.assertTrue(departureCities.contains("Warsaw"));
        Assert.assertTrue(departureCities.contains("Wroclaw"));
    }

    @Test
    public void testFindFlightsToNotFound() {
        //Given
        FlightsRepository flightsRepository = new FlightsRepository();
        flightsRepository.addFlight(new Flight("Warsaw", "Lublin"));
        //When
        SearchService searchService = new SearchService();
        List<String> departureCities = searchService.findFlightsFrom("Warszaw", flightsRepository);
        //Then
        Assert.assertEquals(0, departureCities.size());
    }


    @Test
    public void testFindFlightsWithTransfer() {
        //Given
        FlightsRepository flightsRepository = new FlightsRepository();
        flightsRepository.addFlight(new Flight("Warsaw", "Lublin"));
        flightsRepository.addFlight(new Flight("Lublin", "Wroclaw"));
        flightsRepository.addFlight(new Flight("Warsaw", "Katowice"));
        flightsRepository.addFlight(new Flight("Katowice", "Wroclaw"));
        //When
        SearchService searchService = new SearchService();
        List<String> transferCities = searchService.findFlightsWithTransfer("Warsaw",
                "Wroclaw", flightsRepository);
        //Then
        Assert.assertEquals(2, transferCities.size());
        Assert.assertTrue(transferCities.contains("Lublin"));
        Assert.assertTrue(transferCities.contains("Katowice"));
    }

    @Test
    public void testFindFlightsWithTransferNotFound() {
        //Given
        FlightsRepository flightsRepository = new FlightsRepository();
        flightsRepository.addFlight(new Flight("Warsaw", "Lublin"));
        flightsRepository.addFlight(new Flight("Lublin", "Wroclaw"));
        //When
        SearchService searchService = new SearchService();
        List<String> transferCities = searchService.findFlightsWithTransfer("Warsaw",
                "Katowice", flightsRepository);
        //Then
        Assert.assertEquals(0, transferCities.size());
    }
}
