# Seat Booking Backend

A simple Spring Boot REST API for managing seat bookings with MySQL database.

## Prerequisites

- **Java JDK 11** or higher ([Download](https://www.oracle.com/java/technologies/downloads/))
- **Maven 3.6+** ([Download](https://maven.apache.org/download.cgi))
- **MySQL 8.0+** ([Download](https://dev.mysql.com/downloads/mysql/))

## Database Setup

1. **Start MySQL Server**

2. **Create Database** (Optional - will be auto-created)
   ```sql
   CREATE DATABASE seat_booking_db;
   ```

3. **Update Database Credentials** (if different from defaults)
   
   Edit `src/main/resources/application.properties`:
   ```properties
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

## Running the Backend

### Option 1: Using Maven (Recommended)

```bash
# Navigate to backend directory
cd backend

# Run the application
mvn spring-boot:run
```

### Option 2: Using JAR

```bash
# Build the project
mvn clean package

# Run the JAR
java -jar target/seat-booking-backend-1.0.0.jar
```

The backend will start on **http://localhost:8080**

## API Endpoints

### 1. Get All Bookings
```http
GET http://localhost:8080/api/bookings
```

**Response:**
```json
[
  {
    "id": 1,
    "seatId": "0-5",
    "rowNumber": 0,
    "seatNumber": 5,
    "status": "booked"
  }
]
```

### 2. Create Bookings
```http
POST http://localhost:8080/api/bookings
Content-Type: application/json

[
  {
    "seatId": "0-5",
    "rowNumber": 0,
    "seatNumber": 5,
    "status": "booked"
  },
  {
    "seatId": "1-3",
    "rowNumber": 1,
    "seatNumber": 3,
    "status": "booked"
  }
]
```

### 3. Reset All Bookings
```http
DELETE http://localhost:8080/api/bookings/reset
```

### 4. Health Check
```http
GET http://localhost:8080/api/bookings/health
```

## Testing the API

You can test the API using:

### cURL
```bash
# Get all bookings
curl http://localhost:8080/api/bookings

# Create booking
curl -X POST http://localhost:8080/api/bookings \
  -H "Content-Type: application/json" \
  -d '[{"seatId":"0-5","rowNumber":0,"seatNumber":5,"status":"booked"}]'

# Reset
curl -X DELETE http://localhost:8080/api/bookings/reset
```

### Browser
Simply open: http://localhost:8080/api/bookings

## Project Structure

```
backend/
├── src/
│   └── main/
│       ├── java/com/seatbooking/
│       │   ├── SeatBookingApplication.java   # Main app + CORS config
│       │   ├── Booking.java                  # Entity (database model)
│       │   ├── BookingRepository.java        # Data access layer
│       │   └── BookingController.java        # REST API endpoints
│       └── resources/
│           ├── application.properties        # Configuration
│           └── schema.sql                    # Database schema
├── pom.xml                                   # Maven dependencies
└── README.md                                 # This file
```

## Technologies Used

- **Spring Boot 2.7.18** - Web framework
- **Spring Data JPA** - Database abstraction
- **MySQL** - Relational database
- **Maven** - Build tool

## Troubleshooting

### Port 8080 Already in Use
Change the port in `application.properties`:
```properties
server.port=8081
```

### Cannot Connect to MySQL
- Ensure MySQL is running
- Check username/password in `application.properties`
- Verify database exists or set `createDatabaseIfNotExist=true` in URL

### Build Errors
```bash
# Clean and rebuild
mvn clean install
```

## Next Steps

Once the backend is running:
1. Keep this terminal open
2. Start the React frontend in a new terminal
3. The frontend will automatically connect to this backend
4. Bookings will now persist in the MySQL database!
