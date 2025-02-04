package ru.costumes.rental.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.costumes.rental.DTO.ReviewDTO;
import ru.costumes.rental.model.Costume;
import ru.costumes.rental.model.Review;
import ru.costumes.rental.model.User;
import ru.costumes.rental.repository.CostumeRepository;
import ru.costumes.rental.repository.ReviewRepository;
import ru.costumes.rental.repository.UserRepository;
import ru.costumes.rental.service.ReviewService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CostumeRepository costumeRepository;
    private final UserRepository userRepository;
    @Override
    public List<ReviewDTO> getReviewByCostume(int id) {
        return reviewRepository.findByCostume_CostumeId(id)
                .stream()
                .map(ReviewDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Review addNewReview(Review review) {
        if (review.getCostumeId() != null) {
            Costume costume = costumeRepository.findById(review.getCostumeId())
                    .orElseThrow(() -> new RuntimeException("Costume not found"));
            review.setCostume(costume);
        }

        if (review.getUserId() != null) {
            User user = userRepository.findById(review.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            review.setUser(user);
        }

        review.setCreatedAt(LocalDateTime.now());
        review.setUpdatedAt(LocalDateTime.now());

        return reviewRepository.save(review);
    }
}
