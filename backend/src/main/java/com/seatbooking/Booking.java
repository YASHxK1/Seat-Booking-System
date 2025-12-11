package com.seatbooking;

import javax.persistence.*;

/**
 * Booking Entity
 * Represents a single booked seat in the system
 */
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_id", nullable = false, unique = true)
    private String seatId; // Format: "row-seat" e.g., "0-5" for Row A, Seat 6

    @Column(name = "`row_number`", nullable = false)
    private Integer rowNumber; // 0-7 (A-H)

    @Column(name = "`seat_number`", nullable = false)
    private Integer seatNumber; // 0-9 (1-10)

    @Column(name = "status", nullable = false)
    private String status; // Should be "booked"

    // Default constructor (required by JPA)
    public Booking() {
    }

    // Constructor for easy creation
    public Booking(String seatId, Integer rowNumber, Integer seatNumber, String status) {
        this.seatId = seatId;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", seatId='" + seatId + '\'' +
                ", rowNumber=" + rowNumber +
                ", seatNumber=" + seatNumber +
                ", status='" + status + '\'' +
                '}';
    }
}
