package com.gridnine.testing;

import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
/**
 * Общее время, проведённое на земле превышает два часа
 */

public class MoreTwoHoursOnEarth  implements Filter{
    @Override

    public List<Flight> filter(List<Flight> flightLists) {
        System.out.println("Общее время, проведённое на земле превышает два часа");
        List<Flight> result = new LinkedList<>();
        flightLists.forEach(flight -> {
            int size = flight.getSegments().size();
            if (size > 1){
                int hours= 0;
                for (int i = 1; i < size; i++){
                    hours += (int) ChronoUnit.HOURS.between(flight.getSegments().get(i-1).getArrivalDate()
                            ,flight.getSegments().get(i).getDepartureDate());
                }
                if (hours >=2){
                    result.add(flight);
                }
            }
        });
        return result;
    }
}
