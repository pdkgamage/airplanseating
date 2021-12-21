package com.pradeep.model;

public class Seat {

    private SeatType seatType;
    private Passenger passenger;

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public String toString(){//overriding the toString() method
        return seatType.toString();
    }
}
