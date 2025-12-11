-- Create the bookings table if it doesn't exist
-- Note: Spring Boot with JPA will auto-create this table based on the Entity,
-- but this file serves as documentation and can be run manually if needed

CREATE TABLE IF NOT EXISTS bookings (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    seat_id VARCHAR(10) NOT NULL UNIQUE,
    row_number INT NOT NULL,
    seat_number INT NOT NULL,
    status VARCHAR(20) NOT NULL,
    INDEX idx_seat_id (seat_id),
    INDEX idx_row_seat (row_number, seat_number)
);
