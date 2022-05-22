package com.gridnine.testing;

import java.util.List;

/**
 * Рейсы с датой прилёта раньше даты вылета
 */

public class ArrivalBeforeDeparture implements Filter{
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        System.out.println("Рейсы, у которых дата прилета раньше, чем дата вылета: ");
        return flightList.stream()
                .filter(flight ->
                        flight.getSegments().get(0).getDepartureDate().isAfter(flight.getSegments().get(0).getArrivalDate())).toList();
    }
}
