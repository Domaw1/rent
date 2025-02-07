package ru.costumes.rental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "costume_category")
public class CostumeCategory {

    @Id
    @ManyToOne
//    @JsonIgnore
    @JoinColumn(name = "costume_id", nullable = false)
    private Costume costume;

    @Id
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
