package ru.costumes.rental.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.costumes.rental.DTO.BookingDTO;
import ru.costumes.rental.DTO.CostumesDTO;
import ru.costumes.rental.model.*;
import ru.costumes.rental.repository.*;
import ru.costumes.rental.service.BookingService;
import ru.costumes.rental.service.BookingStatusService;
import ru.costumes.rental.service.CostumeService;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final CostumeRepository costumeRepository;
    private final UserRepository userRepository;
    private final BookingStatusRepository bookingStatusRepository;
    private final StatusRepository statusRepository;


    @Override
    public List<BookingDTO> getBookings() {
        return bookingRepository.findAll().stream()
                .map(BookingDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingDTO> getBookingByCostumeId(int id) {
        return bookingRepository.findBookingByCostume_CostumeId(id)
                .stream()
                .map(BookingDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingDTO> getBookingByUserId(int id) {
        return bookingRepository.findBookingByUser_UserId(id)
                .stream()
                .map(BookingDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Booking addNewBooking(Booking booking) {
        booking.setCreatedAt(LocalDateTime.now());
        booking.setUpdatedAt(LocalDateTime.now());

        if(booking.getCostumeId() != null) {
            Costume costume = costumeRepository.findById(booking.getCostumeId())
                    .orElseThrow(() -> new RuntimeException("Costume not found!"));

            booking.setCostume(costume);
        }

        if(booking.getUserId() != null) {
            User user = userRepository.findById(booking.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found!"));
            booking.setUser(user);
        }

        Status status = statusRepository.findByStatusDescription("Подтверждено");
        BookingStatus newBookingStatus = new BookingStatus();
        newBookingStatus.setBooking(booking);
        newBookingStatus.setStatus(status);

        Booking booking1 = bookingRepository.save(booking);
        bookingStatusRepository.save(newBookingStatus);

        return booking1;
    }
}
