package com.pradeep.model;

public enum SeatType {

    AISLE(0),
    WINDOW(1),
    MIDDLE(2);

    private final int value;

    private SeatType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
