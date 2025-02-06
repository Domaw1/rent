package ru.costumes.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.costumes.rental.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
