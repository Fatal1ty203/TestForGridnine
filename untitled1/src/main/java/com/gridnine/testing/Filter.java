package com.gridnine.testing;

import java.util.List;

public interface Filter {
    public List<Flight> filter(List<Flight> flightList);
}
