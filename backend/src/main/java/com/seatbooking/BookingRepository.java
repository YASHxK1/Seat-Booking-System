package com.seatbooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Booking Repository
 * Spring Data JPA automatically provides implementation for basic CRUD
 * operations
 * No need to write any SQL queries manually!
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // You can add custom query methods here if needed
    // For example:
    // List<Booking> findByRowNumber(Integer rowNumber);
    // Optional<Booking> findBySeatId(String seatId);

    // For now, the built-in methods from JpaRepository are enough:
    // - findAll() - get all bookings
    // - save() - save a booking
    // - deleteAll() - delete all bookings
}
