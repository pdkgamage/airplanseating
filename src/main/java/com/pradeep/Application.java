package com.pradeep;

import com.pradeep.model.Airplane;
import com.pradeep.model.SeatGroup;
import com.pradeep.service.AirplaneService;
import com.pradeep.service.AirplaneServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String args[]) {


        Airplane airplane = new Airplane();
        List<SeatGroup> seatsToAdd = new ArrayList<>();
        AirplaneService airplaneService = new AirplaneServiceImpl();

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String cont = null;
        do {
            // TODO handle exception if user input is not Integer
            System.out.print("Enter Seat Group Row Count : ");
            int rowCount = Integer.parseInt(myObj.nextLine());  // Read user input
            System.out.print("Enter Seat Group Column Count : ");
            int columnCount = Integer.parseInt(myObj.nextLine());  // Read user input
            seatsToAdd.add(new SeatGroup(rowCount, columnCount));
            airplane.setSeatGroups(seatsToAdd);
            System.out.print("Do you wanted to add more seat group. Enter y to continue adding : ");
            cont = myObj.nextLine();  // Read user input
        } while (cont.equalsIgnoreCase("y"));
        System.out.print("How many Passenger to seating in airplane : ");
        int passengerCount = Integer.parseInt(myObj.nextLine());  // Read user input
        airplaneService.indexSeats(seatsToAdd);
        airplaneService.allocateSeat(passengerCount, airplane);
        airplaneService.printAllocatedSeats(airplane);

    }
}
