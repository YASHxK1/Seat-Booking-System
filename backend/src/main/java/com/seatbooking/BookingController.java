package com.seatbooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API Controller
 * Handles all HTTP requests for seat bookings
 */
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    /**
     * GET /api/bookings
     * Returns all booked seats
     */
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        try {
            List<Booking> bookings = bookingRepository.findAll();
            System.out.println("Fetched " + bookings.size() + " bookings from database");
            return ResponseEntity.ok(bookings);
        } catch (Exception e) {
            System.err.println("Error fetching bookings: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * POST /api/bookings
     * Books new seats (accepts an array of bookings)
     */
    @PostMapping
    public ResponseEntity<List<Booking>> createBookings(@RequestBody List<Booking> bookings) {
        try {
            // Save all bookings to the database
            List<Booking> savedBookings = bookingRepository.saveAll(bookings);
            System.out.println("Successfully saved " + savedBookings.size() + " bookings");
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBookings);
        } catch (Exception e) {
            System.err.println("Error saving bookings: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * DELETE /api/bookings/reset
     * Removes all bookings (reset the system)
     */
    @DeleteMapping("/reset")
    public ResponseEntity<Void> resetBookings() {
        try {
            bookingRepository.deleteAll();
            System.out.println("All bookings have been cleared");
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.err.println("Error resetting bookings: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Health check endpoint
     */
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Backend is running!");
    }
}
