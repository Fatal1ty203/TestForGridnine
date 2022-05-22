package com.gridnine.testing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Рейсы с датой прилёта раньше даты вылета
 */

public class ArrivalBeforeDeparture implements Filter{
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        System.out.println("Рейсы, у которых дата прилета раньше, чем дата вылета: ");
        List<Flight> result = new ArrayList<>();
        flightList.forEach(flight -> flight.getSegments()
                                .stream()
                                .filter(segment -> segment.getDepartureDate().isAfter(segment.getArrivalDate()))
                        .limit(1).forEach(s -> result.add(flight)));
        return result;
    }
}
