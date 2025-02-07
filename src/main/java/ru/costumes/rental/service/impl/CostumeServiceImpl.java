package ru.costumes.rental.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.costumes.rental.DTO.CostumesDTO;
import ru.costumes.rental.model.*;
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
    public Costume create(Costume costume, List<Integer> categoryIds, List<String> photos) {
        costume.setCreatedAt(LocalDateTime.now());
        costume.setUpdatedAt(LocalDateTime.now());

        List<Category> categories = categoryRepository.findAllById(categoryIds);

        List<CostumeCategory> costumeCategories = categories.stream()
                .map(category -> {
                    CostumeCategory costumeCategory = new CostumeCategory();
                    costumeCategory.setCostume(costume);
                    costumeCategory.setCategory(category);
                    return costumeCategory;
                })
                .collect(Collectors.toList());

        costume.setCostumeCategories(costumeCategories);

        List<Photo> photoList = photos.stream()
                        .map(photo -> {
                            Photo newPhoto = new Photo();
                            newPhoto.setUrl(photo);
                            newPhoto.setCostume(costume);
                            newPhoto.setCreatedAt(LocalDateTime.now());
                            newPhoto.setUpdatedAt(LocalDateTime.now());
                            return newPhoto;
                        })
                        .collect(Collectors.toList());

        costume.setCostumePhotos(photoList);

        return costumeRepository.save(costume);
    }

    @Override
    public CostumesDTO update(Costume costumeToUpdate, List<Integer> categoryIds, List<String> photos) {
        costumeToUpdate.setCreatedAt(costumeToUpdate.getCreatedAt());
        costumeToUpdate.setUpdatedAt(LocalDateTime.now());

        costumeToUpdate.getCostumeCategories().clear();
        costumeToUpdate.getCostumePhotos().clear();

        if (categoryIds != null) {
            List<Category> categories = categoryRepository.findAllById(categoryIds);
            List<CostumeCategory> costumeCategories = categories.stream()
                    .map(category -> {
                        CostumeCategory costumeCategory = new CostumeCategory();
                        costumeCategory.setCostume(costumeToUpdate);
                        costumeCategory.setCategory(category);
                        return costumeCategory;
                    })
                    .collect(Collectors.toList());
            costumeToUpdate.getCostumeCategories().addAll(costumeCategories);
        }

        if (photos != null) {
            List<Photo> photoList = photos.stream()
                    .map(photo -> {
                        Photo newPhoto = new Photo();
                        newPhoto.setUrl(photo);
                        newPhoto.setCostume(costumeToUpdate);
                        newPhoto.setCreatedAt(LocalDateTime.now());
                        newPhoto.setUpdatedAt(LocalDateTime.now());
                        return newPhoto;
                    })
                    .collect(Collectors.toList());
            costumeToUpdate.getCostumePhotos().addAll(photoList);
        }

        Costume newCostume = costumeRepository.save(costumeToUpdate);
        return new CostumesDTO(newCostume);
    }

    @Override
    @Transactional
    public void deleteCostume(int costumeId) {
        costumeRepository.deleteById(costumeId);
    }
}
