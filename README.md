# 🎫 Seat Booking System

A modern, full-stack seat booking application with a beautiful React frontend and a robust Spring Boot backend with MySQL database persistence.

---

## 🌗 UI Preview

### 🌞 Light Mode
<img src="images/lightmode.jpg" width="500" />

### 🌙 Dark Mode
<img src="images/darkmode.jpg" width="500" />

---

## 🏗️ Architecture

This is a **full-stack application** with clear separation of concerns:

### **Frontend** (React)
- Modern React 18.2.0 with hooks
- Responsive, theme-aware UI
- Client-side validation & state management
- localStorage for offline persistence

### **Backend** (Spring Boot)
- Spring Boot 2.7.18 REST API
- Spring Data JPA for ORM
- MySQL database for persistent storage
- RESTful API design

### **Database** (MySQL)
- Normalized schema with indexed fields
- Stores seat bookings with row/seat metadata
- Auto-creation with JPA entity mapping

---

## 🚀 Features

### 🎯 Core Booking Logic
- **8×10 seat matrix** with row-wise pricing tiers  
- Three seat states: **Available**, **Selected**, **Booked**  
- Interactive seat selection with smooth UX  
- Booked seats are locked and cannot be modified  

### 💰 Dynamic Pricing System
| Row Range | Category | Price per Seat |
|-----------|----------|----------------|
| A–C       | Premium  | ₹1,000         |
| D–F       | Standard | ₹750           |
| G–H       | Economy  | ₹500           |

- Real-time price calculation  
- Category-based visual indicators  

### 🧪 Smart Validation Rules
- **Maximum 8 seats** per booking transaction  
- **Continuity Rule:** Prevents isolating single available seats  
- Detailed error feedback for invalid selections  
- Backend validation for data integrity  

### 🧾 Booking Confirmation Flow
- Confirmation modal with seat details + total price  
- **Confirm** → Persist to database + mark as booked  
- **Cancel** → Maintain selection for review  

### 💾 Dual Persistence Strategy
- **localStorage:** Client-side caching for instant load  
- **MySQL Database:** Server-side persistence for multi-user scenarios  
- Sync between frontend and backend on load/save  

### 🧹 Management Actions
- **Clear Selection** → Remove only selected seats  
- **Reset All** → Clear localStorage + database (full system reset)  

### ✨ Premium UX Features
- 🔄 Light/Dark theme toggle with smooth transitions  
- 🎨 Modern glassmorphism UI with gradients  
- 🪑 Smooth seat animations with pop effects  
- 🏷 Selected seat chips with individual remove buttons  
- 📱 Fully responsive layout (mobile/tablet/desktop)  
- ⚡ Optimistic UI updates with backend sync  

---

## 📁 Project Structure

```
Seat-Booking-System/
├── frontend/
│   ├── src/
│   │   ├── SeatBooking.js       # Main booking component + logic
│   │   ├── SeatBooking.css      # Styling, theming, animations
│   │   ├── App.js               # Root component
│   │   ├── index.js             # React entry point
│   │   └── index.css            # Global styles
│   ├── public/                  # Static assets
│   └── package.json             # Frontend dependencies
│
├── backend/
│   ├── src/main/
│   │   ├── java/com/seatbooking/
│   │   │   ├── SeatBookingApplication.java  # Spring Boot entry
│   │   │   ├── Booking.java                 # JPA entity
│   │   │   ├── BookingRepository.java       # Data access layer
│   │   │   └── BookingController.java       # REST API endpoints
│   │   └── resources/
│   │       ├── application.properties       # DB config
│   │       └── schema.sql                   # Database schema
│   └── pom.xml                              # Maven dependencies
│
├── images/                      # Screenshots
├── .gitignore                   # Git ignore rules
└── README.md                    # This file
```

---

## 🔌 API Endpoints

Base URL: `http://localhost:8080`

### **GET** `/api/bookings`
Fetch all booked seats from the database.

**Response:** `200 OK`
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

### **POST** `/api/bookings`
Create new seat bookings (bulk operation).

**Request Body:**
```json
[
  {
    "seatId": "2-3",
    "rowNumber": 2,
    "seatNumber": 3,
    "status": "booked"
  }
]
```

**Response:** `201 CREATED`

### **DELETE** `/api/bookings/reset`
Clear all bookings (reset system).

**Response:** `200 OK`

### **GET** `/api/bookings/health`
Health check endpoint.

**Response:** `200 OK` - `"Backend is running!"`

---

## ⚙️ Tech Stack

### Frontend
- **Framework:** React 18.2.0
- **Styling:** Vanilla CSS with CSS Variables
- **State Management:** React Hooks (useState, useEffect)
- **Storage:** localStorage API
- **HTTP Client:** Fetch API

### Backend
- **Framework:** Spring Boot 2.7.18
- **Language:** Java 11
- **ORM:** Spring Data JPA / Hibernate
- **Database:** MySQL 8.0
- **Build Tool:** Maven
- **Server:** Embedded Tomcat

---

## 🚀 Getting Started

### Prerequisites
- **Node.js** 14+ and npm
- **Java** 11+
- **Maven** 3.6+
- **MySQL** 8.0+

### Backend Setup

1. **Install MySQL** and create database:
   ```sql
   CREATE DATABASE seat_booking_db;
   ```

2. **Configure Database** (if credentials differ):
   Edit `backend/src/main/resources/application.properties`:
   ```properties
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. **Build and Run Backend:**
   ```bash
   cd backend
   mvn clean install
   mvn spring-boot:run
   ```
   Backend runs on: **http://localhost:8080**

4. **Verify Backend:**
   ```bash
   curl http://localhost:8080/api/bookings/health
   # Output: "Backend is running!"
   ```

### Frontend Setup

1. **Install Dependencies:**
   ```bash
   npm install
   ```

2. **Start Development Server:**
   ```bash
   npm start
   ```
   Frontend runs on: **http://localhost:3000**

3. **Build for Production:**
   ```bash
   npm run build
   ```

---

## 🧪 Testing

### Backend API Testing

**Using cURL:**
```bash
# Get all bookings
curl http://localhost:8080/api/bookings

# Create booking
curl -X POST http://localhost:8080/api/bookings \
  -H "Content-Type: application/json" \
  -d '[{"seatId":"0-5","rowNumber":0,"seatNumber":5,"status":"booked"}]'

# Reset all bookings
curl -X DELETE http://localhost:8080/api/bookings/reset
```

### Manual Testing Checklist
- [ ] Select multiple seats and verify price calculation  
- [ ] Test continuity rule by creating gaps  
- [ ] Test 8-seat booking limit  
- [ ] Confirm booking persists after page refresh  
- [ ] Test light/dark theme toggle  
- [ ] Reset system and verify all data clears  

---

## 🗄️ Database Schema

```sql
CREATE TABLE bookings (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    seat_id VARCHAR(10) NOT NULL UNIQUE,
    row_number INT NOT NULL,
    seat_number INT NOT NULL,
    status VARCHAR(20) NOT NULL,
    INDEX idx_seat_id (seat_id),
    INDEX idx_row_seat (row_number, seat_number)
);
```

---

## 🔧 Configuration

### Frontend Environment
No additional environment variables required. API endpoint is hardcoded to `http://localhost:8080`.

To change backend URL, edit the fetch calls in `SeatBooking.js`.

### Backend Configuration
Edit `backend/src/main/resources/application.properties`:

```properties
# Server Port
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/seat_booking_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

# JPA Settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🐛 Troubleshooting

| Issue | Solution |
|-------|----------|
| **Backend won't start** | Verify MySQL is running and credentials are correct |
| **CORS errors** | Backend includes CORS configuration; ensure it's running on port 8080 |
| **Seats not persisting** | Check browser console for API errors; verify backend health endpoint |
| **Database connection failed** | Ensure `seat_booking_db` database exists in MySQL |

---

## 📝 License

This project is created for educational/assessment purposes.

---

## 👤 Author

**GreenStitch Frontend Assessment Submission**

For questions or feedback, please review the included `VIDEO_LINK.txt` for a complete walkthrough.

---

## 🙏 Acknowledgments

- Original **GreenStitch Frontend Assessment** requirements  
- Enhanced with **full-stack capabilities** for real-world applicability  
- Modern UI inspired by contemporary web design trends
