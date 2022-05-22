package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *  Вылет до текущего момента времени
 */

public class FlightAlreadySent implements Filter{
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        System.out.println("Рейсы, которые уже вылетели: ");
        List<Flight> result = new ArrayList<>();
        flightList.forEach(flight -> flight.getSegments()
                .stream().filter(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now()))
                .forEach(s -> result.add(flight)));
        return result;
    }
}
