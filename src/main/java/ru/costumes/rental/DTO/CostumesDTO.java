package ru.costumes.rental.DTO;

import lombok.Data;
import ru.costumes.rental.model.Costume;
import ru.costumes.rental.model.Photo;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CostumesDTO {
    private Integer costumeId;
    private String name;
    private Double pricePerDay;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<String> categories;
    private List<String> photos;

    public CostumesDTO(Costume costume) {
        this.costumeId = costume.getCostumeId();
        this.name = costume.getName();
        this.pricePerDay = costume.getPricePerDay();
        this.createdAt = costume.getCreatedAt();
        this.updatedAt = costume.getUpdatedAt();
        this.categories = costume.getCostumeCategories().stream()
                .map(costumeCategory -> costumeCategory.getCategory().getCategoryName())
                .collect(Collectors.toList());

        this.photos = costume.getCostumePhotos().stream()
                .map(Photo::getUrl)
                .collect(Collectors.toList());
    }
}