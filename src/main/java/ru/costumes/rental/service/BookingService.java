package ru.costumes.rental.service;

import org.springframework.data.jpa.repository.EntityGraph;
import ru.costumes.rental.DTO.BookingDTO;
import ru.costumes.rental.model.Booking;

import java.util.List;

public interface BookingService {
    @EntityGraph(attributePaths = {"bookingStatuses.status"})
    List<BookingDTO> getBookings();
    List<BookingDTO> getBookingByCostumeId(int id);
    List<BookingDTO> getBookingByUserId(int id);
    Booking addNewBooking(Booking booking);
}
