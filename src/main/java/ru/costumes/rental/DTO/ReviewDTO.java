package ru.costumes.rental.DTO;

import lombok.Data;
import ru.costumes.rental.model.Review;
import ru.costumes.rental.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ReviewDTO {
    private Integer reviewId;
    private CostumesDTO costume;
    private User user;
    private Integer qualityRating;
    private String feedback;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ReviewDTO(Review review) {
        this.reviewId = review.getReviewId();
        this.costume = new CostumesDTO(review.getCostume());
        this.user = review.getUser();
        this.qualityRating = review.getQualityRating();
        this.feedback = review.getFeedback();
        this.createdAt = review.getCreatedAt();
        this.updatedAt = review.getUpdatedAt();
    }
}
