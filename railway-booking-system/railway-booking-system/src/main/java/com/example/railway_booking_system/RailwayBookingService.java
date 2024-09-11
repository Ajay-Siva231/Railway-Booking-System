package com.example.railway_booking_system;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RailwayBookingService {

    @Autowired
    private Mangement management;

    public String bookTicket(BookingRequest request) {
        Booking booking = new Booking(request.getName(), request.getAge(), request.getSex());
        boolean isBooked = management.BookingTicket(booking);

        if (isBooked) {
            return "Booking Successful for PNR: " + booking.getPnr();
        } else {
            return "Booking Failed. Waiting list full.";
        }
    }

    public String cancelTicket(PnrRequest request) {
        boolean isCancelled = management.CancelTicket(request.getPnr());

        if (isCancelled) {
            return "Cancellation Successful for PNR: " + request.getPnr();
        } else {
            return "Cancellation Failed. Invalid PNR.";
        }
    }

    public String checkStatus(int pnr) {
        return management.showStatus(pnr);
    }
}
