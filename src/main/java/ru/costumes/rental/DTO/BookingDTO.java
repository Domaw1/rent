package ru.costumes.rental.DTO;

import lombok.Data;
import ru.costumes.rental.model.Booking;
import ru.costumes.rental.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class BookingDTO {
    private Integer bookingId;
    private CostumesDTO costume;
    private User user;
    private LocalDate rentalStartDate;
    private LocalDate rentalEndDate;
    private Double finalAmount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<String> bookedDates;
    private List<String> statuses;

    public BookingDTO(Booking booking) {
        this.bookingId = booking.getBookingId();
        this.costume = new CostumesDTO(booking.getCostume());
        this.user = booking.getUser();
        this.rentalStartDate = booking.getRentalStartDate();
        this.rentalEndDate = booking.getRentalEndDate();
        this.finalAmount = booking.getFinalAmount();
        this.createdAt = booking.getCreatedAt();
        this.updatedAt = booking.getUpdatedAt();

        this.statuses = booking.getBookingStatuses().stream()
                .map(bookingStatus -> bookingStatus.getStatus().getStatusDescription())
                .collect(Collectors.toList());
    }
}
