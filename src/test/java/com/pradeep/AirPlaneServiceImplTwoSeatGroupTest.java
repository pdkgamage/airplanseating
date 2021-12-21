package com.pradeep;

import com.pradeep.model.Airplane;
import com.pradeep.model.SeatGroup;
import com.pradeep.model.SeatType;
import com.pradeep.service.AirplaneService;
import com.pradeep.service.AirplaneServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AirPlaneServiceImplTwoSeatGroupTest {
    Airplane airPlane = new Airplane();
    AirplaneService airplaneService = new AirplaneServiceImpl();

    @Before
    public void init() {

        List<SeatGroup> seatsToAdd = new ArrayList<>();
        seatsToAdd.add(new SeatGroup(5, 3));
        seatsToAdd.add(new SeatGroup(2, 2));
        airPlane.setSeatGroups(seatsToAdd);
        airplaneService.indexSeats(seatsToAdd);
        airplaneService.allocateSeat(10, airPlane);
    }

    @Test
    public void seatGroupLengthTest() {

        List<SeatGroup> seatsInAirPlane = airPlane.getSeatGroups();

        Assert.assertEquals(5, seatsInAirPlane.get(0).getSeats().length);
        Assert.assertEquals(3, seatsInAirPlane.get(0).getSeats()[0].length);
        Assert.assertEquals(2, seatsInAirPlane.get(1).getSeats().length);
        Assert.assertEquals(2, seatsInAirPlane.get(1).getSeats()[0].length);

    }


    @Test
    public void seatIndexingTest() {

        List<SeatGroup> seatsInAirPlane = airPlane.getSeatGroups();

        Assert.assertEquals(SeatType.WINDOW, seatsInAirPlane.get(0).getSeats()[0][0].getSeatType());
        Assert.assertEquals(SeatType.WINDOW, seatsInAirPlane.get(0).getSeats()[0][1].getSeatType());
        Assert.assertEquals(SeatType.WINDOW, seatsInAirPlane.get(0).getSeats()[0][2].getSeatType());

        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(0).getSeats()[1][0].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(0).getSeats()[1][1].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(0).getSeats()[1][2].getSeatType());

        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(0).getSeats()[2][0].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(0).getSeats()[2][1].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(0).getSeats()[2][2].getSeatType());

        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(0).getSeats()[3][0].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(0).getSeats()[3][1].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(0).getSeats()[3][2].getSeatType());


        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(0).getSeats()[4][0].getSeatType());
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(0).getSeats()[4][1].getSeatType());
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(0).getSeats()[4][2].getSeatType());


        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(1).getSeats()[0][0].getSeatType());
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(1).getSeats()[0][1].getSeatType());
        Assert.assertEquals(SeatType.WINDOW, seatsInAirPlane.get(1).getSeats()[1][0].getSeatType());
        Assert.assertEquals(SeatType.WINDOW, seatsInAirPlane.get(1).getSeats()[1][1].getSeatType());

    }


    @Test
    public void AllocatingPassengerSeatingTest() {

        List<SeatGroup> seatsInAirPlane = airPlane.getSeatGroups();

        Assert.assertEquals(6, seatsInAirPlane.get(0).getSeats()[0][0].getPassenger().getPassengerId());
        Assert.assertEquals(8, seatsInAirPlane.get(0).getSeats()[0][1].getPassenger().getPassengerId());
        Assert.assertEquals(10, seatsInAirPlane.get(0).getSeats()[0][2].getPassenger().getPassengerId());
        Assert.assertNull(seatsInAirPlane.get(0).getSeats()[1][0].getPassenger());
        Assert.assertNull(seatsInAirPlane.get(0).getSeats()[1][1].getPassenger());
        Assert.assertNull(seatsInAirPlane.get(0).getSeats()[1][2].getPassenger());
        Assert.assertEquals(1, seatsInAirPlane.get(0).getSeats()[4][0].getPassenger().getPassengerId());
        Assert.assertEquals(3, seatsInAirPlane.get(0).getSeats()[4][1].getPassenger().getPassengerId());
        Assert.assertEquals(5, seatsInAirPlane.get(0).getSeats()[4][2].getPassenger().getPassengerId());

        Assert.assertEquals(2, seatsInAirPlane.get(1).getSeats()[0][0].getPassenger().getPassengerId());
        Assert.assertEquals(4, seatsInAirPlane.get(1).getSeats()[0][1].getPassenger().getPassengerId());
        Assert.assertEquals(7, seatsInAirPlane.get(1).getSeats()[1][0].getPassenger().getPassengerId());
        Assert.assertEquals(9, seatsInAirPlane.get(1).getSeats()[1][1].getPassenger().getPassengerId());

    }
}
