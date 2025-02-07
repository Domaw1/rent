package ru.costumes.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.costumes.rental.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {
    Status findByStatusDescription(String description);
}
