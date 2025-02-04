package ru.costumes.rental.service;

import ru.costumes.rental.DTO.ReviewDTO;
import ru.costumes.rental.model.Review;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> getReviewByCostume(int id);
    Review addNewReview(Review review);
}
