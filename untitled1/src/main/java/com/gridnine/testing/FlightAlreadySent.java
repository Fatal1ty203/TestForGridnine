package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

/**
 *  Вылет до текущего момента времени
 */

public class FlightAlreadySent implements Filter{
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        System.out.println("Рейсы, которые уже вылетели: ");
        return flightList.stream()
                .filter(flight -> flight.getSegments().get(0).getDepartureDate().isBefore(LocalDateTime.now()))
                .toList();
    }
}
