package ru.costumes.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.costumes.rental.model.Booking;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findBookingByCostume_CostumeId(Integer costumeCostumeId);
    List<Booking> findBookingByUser_UserId(Integer userId);
}
