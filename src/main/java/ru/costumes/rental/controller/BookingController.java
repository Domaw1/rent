package ru.costumes.rental.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.costumes.rental.DTO.BookingDTO;
import ru.costumes.rental.model.Booking;
import ru.costumes.rental.service.BookingService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/bookings")
public class BookingController {
    private final BookingService bookingService;

    @GetMapping
    public List<BookingDTO> getAllBookings() {
        return bookingService.getBookings();
    }

    @GetMapping("/{costumeId}")
    public List<BookingDTO> getBookingById(@PathVariable int costumeId) {
        return bookingService.getBookingByCostumeId(costumeId);
    }

    @GetMapping("/user/{userId}")
    public List<BookingDTO> getBookingByUserId(@PathVariable int userId) {
        return bookingService.getBookingByUserId(userId);
    }
}
