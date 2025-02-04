package ru.costumes.rental.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.costumes.rental.DTO.ReviewDTO;
import ru.costumes.rental.model.Review;
import ru.costumes.rental.service.ReviewService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/{id}")
    public List<ReviewDTO> getReview(@PathVariable int id) {
        return reviewService.getReviewByCostume(id);
    }

    @PostMapping
    public Review addReview(@RequestBody Review review)
    {
        return reviewService.addNewReview(review);
    }
}
