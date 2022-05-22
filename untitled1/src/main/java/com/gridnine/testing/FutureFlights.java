package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Рейсы с датой вылета позднее текущей даты
 */

public class FutureFlights implements Filter{

    @Override
    public List<Flight> filter(List<Flight> flightList) {
        System.out.println("Предстоящие рейсы : ");
        List<Flight> result = new ArrayList<>();
         flightList.forEach(flight -> flight.getSegments().stream()
                 .filter(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now())).limit(1).forEach(s -> result.add(flight)));
         return result;
    }
}
