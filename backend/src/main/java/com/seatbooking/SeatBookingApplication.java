package com.seatbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Main Spring Boot Application
 * This is the entry point for our seat booking backend
 */
@SpringBootApplication
public class SeatBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeatBookingApplication.class, args);
        System.out.println("\n========================================");
        System.out.println("Seat Booking Backend is running!");
        System.out.println("API available at: http://localhost:8080/api/bookings");
        System.out.println("========================================\n");
    }

    /**
     * CORS Configuration
     * Allows the React frontend (running on port 3000) to communicate with this backend
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
