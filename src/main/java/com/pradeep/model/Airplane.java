package com.pradeep.model;

import java.util.List;

public class Airplane {

    private List<SeatGroup> seatGroups;

    public List<SeatGroup> getSeatGroups() {
        return seatGroups;
    }

    public void setSeatGroups(List<SeatGroup> seatGroups) {
        this.seatGroups = seatGroups;
    }

}