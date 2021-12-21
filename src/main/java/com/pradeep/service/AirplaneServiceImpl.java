package com.pradeep.service;

import com.pradeep.model.*;

import java.util.Arrays;
import java.util.List;

public class AirplaneServiceImpl implements AirplaneService {

    @Override
    public void indexSeats(List<SeatGroup> seatGroups) {
        Seat[][] firstSeatGroupSeats = seatGroups.get(0).getSeats();

        if (seatGroups.size() == 1) {
            for (int j = 0; j < firstSeatGroupSeats.length; j++) {
                for (int k = 0; k < firstSeatGroupSeats[j].length; k++) {
                    if (j == 0) {
                        firstSeatGroupSeats[j][k].setSeatType(SeatType.WINDOW);
                    } else if (j != firstSeatGroupSeats.length - 1) {
                        firstSeatGroupSeats[j][k].setSeatType(SeatType.MIDDLE);
                    } else {
                        firstSeatGroupSeats[j][k].setSeatType(SeatType.WINDOW);
                    }
                }
            }
        } else {
            for (int j = 0; j < firstSeatGroupSeats.length; j++) {
                for (int k = 0; k < firstSeatGroupSeats[j].length; k++) {
                    if (j == 0) {
                        firstSeatGroupSeats[j][k].setSeatType(SeatType.WINDOW);
                    } else if (j != firstSeatGroupSeats.length - 1) {
                        firstSeatGroupSeats[j][k].setSeatType(SeatType.MIDDLE);
                    } else {
                        firstSeatGroupSeats[j][k].setSeatType(SeatType.AISLE);
                    }
                }
            }

            Seat[][] lastSeatGroupSeats = seatGroups.get(seatGroups.size() - 1).getSeats();
            for (int j = lastSeatGroupSeats.length - 1; j >= 0; j--) {
                for (int k = 0; k < lastSeatGroupSeats[j].length; k++) {
                    if (j == lastSeatGroupSeats.length - 1) {
                        lastSeatGroupSeats[j][k].setSeatType(SeatType.WINDOW);
                    } else if (j != 0) {
                        lastSeatGroupSeats[j][k].setSeatType(SeatType.MIDDLE);
                    } else {
                        lastSeatGroupSeats[j][k].setSeatType(SeatType.AISLE);
                    }
                }
            }
            if (seatGroups.size() > 2) {
                for (int i = 1; i < seatGroups.size() - 1; i++) {
                    SeatGroup seatGroup = seatGroups.get(i);
                    Seat[][] seatsInGroup = seatGroup.getSeats();
                    for (int j = 0; j < seatsInGroup.length; j++) {
                        for (int k = 0; k < seatsInGroup[j].length; k++) {
                            if (j == 0) {
                                seatsInGroup[j][k].setSeatType(SeatType.AISLE);
                            } else if (j != seatsInGroup.length - 1) {
                                seatsInGroup[j][k].setSeatType(SeatType.MIDDLE);
                            } else {
                                seatsInGroup[j][k].setSeatType(SeatType.AISLE);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void allocateSeat(int numOfPassengers, Airplane airplane) {
        int passengerCount = 1;
        int maxColoumnountInSeatGroups = getMaxColomnCountInSeatGroups(airplane.getSeatGroups());

        for (int i = 0; i < maxColoumnountInSeatGroups; i++) {
            for (SeatGroup seatGroup : airplane.getSeatGroups()) {
                Seat[][] seats = seatGroup.getSeats();
                if (i < seats[0].length) {
                    for (Seat[] seat : seats) {
                        if (SeatType.AISLE.equals(seat[i].getSeatType())) {
                            seat[i].setPassenger(new Passenger(passengerCount));
                            passengerCount++;
                            if (passengerCount > numOfPassengers) return;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < maxColoumnountInSeatGroups; i++) {
            for (SeatGroup seatGroup : airplane.getSeatGroups()) {
                Seat[][] seats = seatGroup.getSeats();
                if (i < seats[0].length) {
                    for (Seat[] seat : seats) {
                        if (SeatType.WINDOW.equals(seat[i].getSeatType())) {
                            seat[i].setPassenger(new Passenger(passengerCount));
                            passengerCount++;
                            if (passengerCount > numOfPassengers) return;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < maxColoumnountInSeatGroups; i++) {
            for (SeatGroup seatGroup : airplane.getSeatGroups()) {
                Seat[][] seats = seatGroup.getSeats();
                if (i < seats[0].length) {
                    for (Seat[] seat : seats) {
                        if (SeatType.MIDDLE.equals(seat[i].getSeatType())) {
                            seat[i].setPassenger(new Passenger(passengerCount));
                            passengerCount++;
                            if (passengerCount > numOfPassengers) return;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void printAllocatedSeats(Airplane airplane) {


        for(int j = 0; j < airplane.getSeatGroups().size(); j++) {
            Seat[][] arr = airplane.getSeatGroups().get(j).getSeats();
            System.out.println("\n"+ (j+1) + "  Seat Group \n");
            for (int i = 0; i < arr.length; i++) {
                for (int k = 0; k < arr[i].length; k++) {
                    try {
                        System.out.print(" | " + arr[i][k].getSeatType() + " " + arr[i][k].getPassenger().getPassengerId() + " | ");
                    } catch (NullPointerException e) {
                        System.out.print(" | " + arr[i][k].getSeatType() + " " + "No Passenger" + " | ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }

    }

    private int getMaxColomnCountInSeatGroups(List<SeatGroup> seatGroups) {
        int maxColCountInSeatGroups = 0;
        for (SeatGroup seatGroup : seatGroups) {
            if (seatGroup.getSeats()[0].length > maxColCountInSeatGroups) {
                maxColCountInSeatGroups = seatGroup.getSeats()[0].length;
            }
        }
        return maxColCountInSeatGroups;
    }
}
