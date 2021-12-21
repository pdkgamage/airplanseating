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

public class AirplaneServiceMultipleSeatGroupTest {

    Airplane airPlane = new Airplane();
    AirplaneService airplaneService = new AirplaneServiceImpl();

    @Before
    public void init() {

        List<SeatGroup> seatsGroups = new ArrayList<>();
        seatsGroups.add(new SeatGroup(3, 2));
        seatsGroups.add(new SeatGroup(4, 3));
        seatsGroups.add(new SeatGroup(2, 3));
        seatsGroups.add(new SeatGroup(3, 4));
        airPlane.setSeatGroups(seatsGroups);
        airplaneService.indexSeats(seatsGroups);
        airplaneService.allocateSeat(30, airPlane);
    }

    @Test
    public void seatGroupLengthTest() {

        List<SeatGroup> seatsInAirPlane = airPlane.getSeatGroups();

        Assert.assertEquals(3, seatsInAirPlane.get(0).getSeats().length);
        Assert.assertEquals(2, seatsInAirPlane.get(0).getSeats()[0].length);
        Assert.assertEquals(4, seatsInAirPlane.get(1).getSeats().length);
        Assert.assertEquals(3, seatsInAirPlane.get(1).getSeats()[0].length);
        Assert.assertEquals(2, seatsInAirPlane.get(2).getSeats().length);
        Assert.assertEquals(3, seatsInAirPlane.get(2).getSeats()[0].length);
        Assert.assertEquals(3, seatsInAirPlane.get(3).getSeats().length);
        Assert.assertEquals(4, seatsInAirPlane.get(3).getSeats()[0].length);

    }


    @Test
    public void seatIndexingTest() {

        List<SeatGroup> seatsInAirPlane = airPlane.getSeatGroups();
        // indexing first seat group test
        Assert.assertEquals(SeatType.WINDOW, seatsInAirPlane.get(0).getSeats()[0][0].getSeatType());
        Assert.assertEquals(SeatType.WINDOW, seatsInAirPlane.get(0).getSeats()[0][1].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(0).getSeats()[1][0].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(0).getSeats()[1][1].getSeatType());
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(0).getSeats()[2][0].getSeatType());
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(0).getSeats()[2][1].getSeatType());

        // indexing second seat group test
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(1).getSeats()[0][0].getSeatType());
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(1).getSeats()[0][1].getSeatType());
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(1).getSeats()[0][2].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(1).getSeats()[1][0].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(1).getSeats()[1][1].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(1).getSeats()[1][2].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(1).getSeats()[2][0].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(1).getSeats()[2][1].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(1).getSeats()[2][2].getSeatType());
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(1).getSeats()[3][0].getSeatType());
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(1).getSeats()[3][1].getSeatType());
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(1).getSeats()[3][2].getSeatType());

        // indexing third seat group test
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(2).getSeats()[0][0].getSeatType());
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(2).getSeats()[0][1].getSeatType());
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(2).getSeats()[0][2].getSeatType());
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(2).getSeats()[1][0].getSeatType());
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(2).getSeats()[1][1].getSeatType());
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(2).getSeats()[1][2].getSeatType());

        // indexing fourth seat group test
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(3).getSeats()[0][0].getSeatType());
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(3).getSeats()[0][1].getSeatType());
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(3).getSeats()[0][2].getSeatType());
        Assert.assertEquals(SeatType.AISLE, seatsInAirPlane.get(3).getSeats()[0][3].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(3).getSeats()[1][0].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(3).getSeats()[1][1].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(3).getSeats()[1][2].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(3).getSeats()[1][3].getSeatType());
        Assert.assertEquals(SeatType.WINDOW, seatsInAirPlane.get(3).getSeats()[2][0].getSeatType());
        Assert.assertEquals(SeatType.WINDOW, seatsInAirPlane.get(3).getSeats()[2][1].getSeatType());
        Assert.assertEquals(SeatType.WINDOW, seatsInAirPlane.get(3).getSeats()[2][2].getSeatType());
        Assert.assertEquals(SeatType.WINDOW, seatsInAirPlane.get(3).getSeats()[2][3].getSeatType());
    }


    @Test
    public void AllocatingPassengerSeatingTest() {

        List<SeatGroup> seatsInAirPlane = airPlane.getSeatGroups();

        Assert.assertEquals(1, seatsInAirPlane.get(0).getSeats()[2][0].getPassenger().getPassengerId());
        Assert.assertEquals(2, seatsInAirPlane.get(1).getSeats()[0][0].getPassenger().getPassengerId());
        Assert.assertEquals(3, seatsInAirPlane.get(1).getSeats()[3][0].getPassenger().getPassengerId());
        Assert.assertEquals(4, seatsInAirPlane.get(2).getSeats()[0][0].getPassenger().getPassengerId());
        Assert.assertEquals(5, seatsInAirPlane.get(2).getSeats()[1][0].getPassenger().getPassengerId());
        Assert.assertEquals(6, seatsInAirPlane.get(3).getSeats()[0][0].getPassenger().getPassengerId());
        Assert.assertEquals(7, seatsInAirPlane.get(0).getSeats()[2][1].getPassenger().getPassengerId());
        Assert.assertEquals(8, seatsInAirPlane.get(1).getSeats()[0][1].getPassenger().getPassengerId());
        Assert.assertEquals(9, seatsInAirPlane.get(1).getSeats()[3][1].getPassenger().getPassengerId());
        Assert.assertEquals(10, seatsInAirPlane.get(2).getSeats()[0][1].getPassenger().getPassengerId());
        Assert.assertEquals(11, seatsInAirPlane.get(2).getSeats()[1][1].getPassenger().getPassengerId());
        Assert.assertEquals(12, seatsInAirPlane.get(3).getSeats()[0][1].getPassenger().getPassengerId());
        Assert.assertEquals(13, seatsInAirPlane.get(1).getSeats()[0][2].getPassenger().getPassengerId());
        Assert.assertEquals(14, seatsInAirPlane.get(1).getSeats()[3][2].getPassenger().getPassengerId());
        Assert.assertEquals(15, seatsInAirPlane.get(2).getSeats()[0][2].getPassenger().getPassengerId());
        Assert.assertEquals(16, seatsInAirPlane.get(2).getSeats()[1][2].getPassenger().getPassengerId());
        Assert.assertEquals(17, seatsInAirPlane.get(3).getSeats()[0][2].getPassenger().getPassengerId());
        Assert.assertEquals(18, seatsInAirPlane.get(3).getSeats()[0][3].getPassenger().getPassengerId());
        Assert.assertEquals(19, seatsInAirPlane.get(0).getSeats()[0][0].getPassenger().getPassengerId());
        Assert.assertEquals(20, seatsInAirPlane.get(3).getSeats()[2][0].getPassenger().getPassengerId());
        Assert.assertEquals(21, seatsInAirPlane.get(0).getSeats()[0][1].getPassenger().getPassengerId());
        Assert.assertEquals(22, seatsInAirPlane.get(3).getSeats()[2][1].getPassenger().getPassengerId());
        Assert.assertEquals(23, seatsInAirPlane.get(3).getSeats()[2][2].getPassenger().getPassengerId());
        Assert.assertEquals(24, seatsInAirPlane.get(3).getSeats()[2][3].getPassenger().getPassengerId());
        Assert.assertEquals(25, seatsInAirPlane.get(0).getSeats()[1][0].getPassenger().getPassengerId());
        Assert.assertEquals(26, seatsInAirPlane.get(1).getSeats()[1][0].getPassenger().getPassengerId());
        Assert.assertEquals(27, seatsInAirPlane.get(1).getSeats()[2][0].getPassenger().getPassengerId());
        Assert.assertEquals(28, seatsInAirPlane.get(3).getSeats()[1][0].getPassenger().getPassengerId());
        Assert.assertEquals(29, seatsInAirPlane.get(0).getSeats()[1][1].getPassenger().getPassengerId());
        Assert.assertEquals(30, seatsInAirPlane.get(1).getSeats()[1][1].getPassenger().getPassengerId());

        Assert.assertNull(seatsInAirPlane.get(1).getSeats()[1][2].getPassenger());
        Assert.assertNull(seatsInAirPlane.get(1).getSeats()[2][1].getPassenger());
        Assert.assertNull(seatsInAirPlane.get(1).getSeats()[2][2].getPassenger());
        Assert.assertNull(seatsInAirPlane.get(3).getSeats()[1][1].getPassenger());
        Assert.assertNull(seatsInAirPlane.get(3).getSeats()[1][2].getPassenger());
        Assert.assertNull(seatsInAirPlane.get(3).getSeats()[1][3].getPassenger());

    }

}
