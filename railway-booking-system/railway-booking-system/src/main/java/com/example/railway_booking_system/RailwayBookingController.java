package com.example.railway_booking_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/railway") // Base path for all requests
public class RailwayBookingController {

    @Autowired
    private RailwayBookingService railwayBookingService;

    // POST to book a ticket
    @PostMapping("/book")
    public ResponseEntity<String> bookTicket(@RequestBody BookingRequest request) {
        String result = railwayBookingService.bookTicket(request);
        return ResponseEntity.ok(result); // Return booking result
    }

    // POST to cancel a ticket
    @PostMapping("/cancel")
    public ResponseEntity<String> cancelTicket(@RequestBody PnrRequest pnrRequest) {
        String result = railwayBookingService.cancelTicket(pnrRequest);
        return ResponseEntity.ok(result); // Return cancellation result
    }

    // GET to check ticket status by PNR
    @GetMapping("/status/{pnr}")
    public ResponseEntity<String> checkStatus(@PathVariable int pnr) {
        String result = railwayBookingService.checkStatus(pnr);
        return ResponseEntity.ok(result); // Return status result
    }
}
