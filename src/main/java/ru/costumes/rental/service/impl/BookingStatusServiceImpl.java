package ru.costumes.rental.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.costumes.rental.model.BookingStatus;
import ru.costumes.rental.service.BookingStatusService;

@Service
@AllArgsConstructor
public class BookingStatusServiceImpl implements BookingStatusService {

    @Override
    public BookingStatus createBookingStatus(BookingStatus bookingStatus) {
        return null;
    }
}
