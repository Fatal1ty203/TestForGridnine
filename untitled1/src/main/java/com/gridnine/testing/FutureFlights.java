package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Рейсы с датой вылета позднее текущей даты
 */

public class FutureFlights implements Filter{

    @Override
    public List<Flight> filter(List<Flight> flightList) {
        System.out.println("Предстоящие рейсы : ");
        return flightList.stream()
                .filter(flight -> flight.getSegments().get(0).getDepartureDate().isAfter(LocalDateTime.now()))
                .toList();
    }
}
