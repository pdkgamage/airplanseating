package com.pradeep.service;

import com.pradeep.model.Airplane;
import com.pradeep.model.SeatGroup;

import java.util.List;

public interface AirplaneService {

    void indexSeats(List<SeatGroup> seatGroups);
    void allocateSeat(int numOfPassengers, Airplane airplane);
    void printAllocatedSeats(Airplane airplane);

}
