package ru.costumes.rental.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import ru.costumes.rental.service.CostumeService;
import ru.costumes.rental.service.UserService;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer reviewId;

    @ManyToOne
    @JoinColumn(name = "costume_id", nullable = false)
    private Costume costume;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Transient
    @JsonProperty("costumeId")
    private Integer costumeId;

    @Transient
    @JsonProperty("userId")
    private Integer userId;

    @Column(name = "quality_rating", nullable = false)
    private Integer qualityRating;

    @Column(name = "feedback", nullable = false)
    private String feedback;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;
}
