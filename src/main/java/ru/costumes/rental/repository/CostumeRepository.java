package ru.costumes.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.costumes.rental.model.Costume;

public interface CostumeRepository extends JpaRepository<Costume, Integer> {
}
