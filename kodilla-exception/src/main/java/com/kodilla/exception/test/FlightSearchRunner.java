package com.kodilla.exception.test;

import java.util.HashSet;
import java.util.Set;

public class FlightSearchRunner {
    public static void main(String[] args){
        Set<Flight> flightsToBeChecked = new HashSet<>();
        Flight firstFlight = new Flight("Warsaw", "Kiev");
        Flight secondFlight = new Flight("Warsaw","Kyiv");
        Flight thirdFlight = new Flight("Paris", "Lviv");
        flightsToBeChecked.add(firstFlight);
        flightsToBeChecked.add(secondFlight);
        flightsToBeChecked.add(thirdFlight);

        FlightFinder finder = new FlightFinder();

        for (Flight flight : flightsToBeChecked){
            try {
                if (finder.findFlight(flight)){
                    System.out.println(flight + " is available!");
                } else {
                    System.out.println("Unfortunately, " + flight + "is at the moment not available!");
                }
            } catch (RouteNotFoundException e) {
                System.out.println("Under request " + flight +
                        " at least one of the indicated airports is not found. Please try other airports or check the spelling!");
            } finally {
                System.out.println("Thank you for using our services!\n");
            }
        }
    }
}
