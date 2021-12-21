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

public class AirplaneServiceImplOneSeatGroupTest {

    Airplane airPlane = new Airplane();
    AirplaneService airplaneService = new AirplaneServiceImpl();

    @Before
    public void init() {

        List<SeatGroup> seatsToAdd = new ArrayList<>();
        seatsToAdd.add(new SeatGroup(3, 2));
        airPlane.setSeatGroups(seatsToAdd);
        airplaneService.indexSeats(seatsToAdd);
        airplaneService.allocateSeat(5, airPlane);
    }

    @Test
    public void seatGroupLengthTest() {

        List<SeatGroup> seatsInAirPlane = airPlane.getSeatGroups();

        Assert.assertEquals(3, seatsInAirPlane.get(0).getSeats().length);
        Assert.assertEquals(2, seatsInAirPlane.get(0).getSeats()[0].length);

    }


    @Test
    public void seatIndexingTest() {

        List<SeatGroup> seatsInAirPlane = airPlane.getSeatGroups();

        Assert.assertEquals(SeatType.WINDOW, seatsInAirPlane.get(0).getSeats()[0][0].getSeatType());
        Assert.assertEquals(SeatType.WINDOW, seatsInAirPlane.get(0).getSeats()[0][1].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(0).getSeats()[1][0].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE, seatsInAirPlane.get(0).getSeats()[1][1].getSeatType());
        Assert.assertEquals(SeatType.WINDOW, seatsInAirPlane.get(0).getSeats()[2][0].getSeatType());
        Assert.assertEquals(SeatType.WINDOW, seatsInAirPlane.get(0).getSeats()[2][1].getSeatType());

    }


    @Test
    public void AllocatingPassengerSeatingTest() {

        List<SeatGroup> seatsInAirPlane = airPlane.getSeatGroups();

        Assert.assertEquals(1, seatsInAirPlane.get(0).getSeats()[0][0].getPassenger().getPassengerId());
        Assert.assertEquals(3, seatsInAirPlane.get(0).getSeats()[0][1].getPassenger().getPassengerId());
        Assert.assertEquals(5, seatsInAirPlane.get(0).getSeats()[1][0].getPassenger().getPassengerId());
        Assert.assertNull(seatsInAirPlane.get(0).getSeats()[1][1].getPassenger());
        Assert.assertEquals(2, seatsInAirPlane.get(0).getSeats()[2][0].getPassenger().getPassengerId());
        Assert.assertEquals(4, seatsInAirPlane.get(0).getSeats()[2][1].getPassenger().getPassengerId());


    }
}
