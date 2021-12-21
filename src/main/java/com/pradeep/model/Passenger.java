package com.pradeep.model;

public class Passenger {

    private int passengerId;

    public Passenger(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String toString() {//overriding the toString() method
        return String.valueOf(passengerId);
    }
}
