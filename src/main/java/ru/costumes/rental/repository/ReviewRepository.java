package ru.costumes.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.costumes.rental.DTO.ReviewDTO;
import ru.costumes.rental.model.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByCostume_CostumeId(int costumeCostumeId);
}
