package com.gridnine.testing;

import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        FilterService service = new FilterService();
        flights.forEach(System.out::println);
        service.setFlightList(flights);
        service.setFilter(new FlightAlreadySent());
        service.usingFilter().forEach(System.out::println);

        service.setFilter(new ArrivalBeforeDeparture());
        service.usingFilter().forEach(System.out::println);

        service.setFilter(new MoreTwoHoursOnEarth());
        service.usingFilter().forEach(System.out::println);

        service.setFilter(new FutureFlights());
        service.usingFilter().forEach(System.out::println);

    }
}
