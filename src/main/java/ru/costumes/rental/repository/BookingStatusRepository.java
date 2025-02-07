package ru.costumes.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.costumes.rental.model.BookingStatus;
import ru.costumes.rental.model.BookingStatusId;

public interface BookingStatusRepository extends JpaRepository<BookingStatus, BookingStatusId> {
}
