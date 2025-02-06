package ru.costumes.rental.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.costumes.rental.DTO.CostumesDTO;
import ru.costumes.rental.model.Booking;
import ru.costumes.rental.model.Category;
import ru.costumes.rental.model.Costume;
import ru.costumes.rental.model.CostumeCategory;
import ru.costumes.rental.repository.BookingRepository;
import ru.costumes.rental.repository.CategoryRepository;
import ru.costumes.rental.repository.CostumeRepository;
import ru.costumes.rental.service.CostumeService;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CostumeServiceImpl implements CostumeService {
    private CostumeRepository costumeRepository;
    private CategoryRepository categoryRepository;
    @Override
    public List<CostumesDTO> getCostumes() {
        return costumeRepository.findAll().stream()
                .map(CostumesDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Costume findById(int id) {
        return costumeRepository.findById(id).orElse(null);
    }

    @Override
    public Costume create(Costume costume, List<Integer> categoryIds) {
        costume.setCreatedAt(LocalDateTime.now());
        costume.setUpdatedAt(LocalDateTime.now());

        List<Category> categories = categoryRepository.findAllById(categoryIds);

        // Привязать категории к костюму
        List<CostumeCategory> costumeCategories = categories.stream()
                .map(category -> {
                    CostumeCategory costumeCategory = new CostumeCategory();
                    costumeCategory.setCostume(costume);
                    costumeCategory.setCategory(category);
                    return costumeCategory;
                })
                .collect(Collectors.toList());

        costume.setCostumeCategories(costumeCategories);

        return costumeRepository.save(costume);
    }
}
