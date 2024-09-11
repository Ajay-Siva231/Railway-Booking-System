package com.example.railway_booking_system;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class Mangement {
    private int BookingAvailable = 60;
    private int BookedSeats = 0;
    private HashMap<Integer, Booking> WaitingList = new HashMap<>();
    private HashMap<Integer, Booking> Passenger = new HashMap<>();

    public boolean BookingTicket(Booking booking) {
        if (BookedSeats < BookingAvailable) {
            Passenger.put(booking.getPnr(), booking);
            BookedSeats++;
            return true;
        } else if (WaitingList.size() < 10) {
            WaitingList.put(booking.getPnr(), booking);
            return true;
        } else {
            return false;
        }
    }

    public boolean CancelTicket(int pnr) {
        if (Passenger.containsKey(pnr)) {
            Passenger.remove(pnr);
            BookedSeats--;
            if (!WaitingList.isEmpty()) {
                int firstWaitingPnr = WaitingList.keySet().iterator().next();
                Booking waitingPassenger = WaitingList.remove(firstWaitingPnr);
                Passenger.put(firstWaitingPnr, waitingPassenger);
                BookedSeats++;
            }
            return true;
        } else {
            return false;
        }
    }

    public String showStatus(int pnr) {
        if (Passenger.containsKey(pnr)) {
            return "Booked Passenger: " + Passenger.get(pnr).toString();
        } else if (WaitingList.containsKey(pnr)) {
            return "Waiting List Passenger: " + WaitingList.get(pnr).toString();
        } else {
            return "Invalid PNR";
        }
    }
}
