package ru.costumes.rental.model;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "costumes")
public class Costume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "costume_id")
    private Integer costumeId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price_per_day")
    private Double pricePerDay;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "costume", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CostumeCategory> costumeCategories;

    @OneToMany(mappedBy = "costume", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> costumePhotos;
}
