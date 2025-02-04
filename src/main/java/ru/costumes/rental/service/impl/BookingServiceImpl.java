package ru.costumes.rental.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.costumes.rental.DTO.BookingDTO;
import ru.costumes.rental.DTO.CostumesDTO;
import ru.costumes.rental.model.Booking;
import ru.costumes.rental.repository.BookingRepository;
import ru.costumes.rental.service.BookingService;
import ru.costumes.rental.service.CostumeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;

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
}
