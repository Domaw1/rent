package ru.costumes.rental.service;

import org.springframework.data.jpa.repository.EntityGraph;
import ru.costumes.rental.DTO.CostumesDTO;
import ru.costumes.rental.model.Costume;

import java.util.List;

public interface CostumeService {
    @EntityGraph(attributePaths = {"costumeCategories.category"})
    List<CostumesDTO> getCostumes();

    Costume findById(int id);
    CostumesDTO getById(int id);
    Costume create(Costume costume, List<Integer> categoryIds, List<String> photos);
    CostumesDTO update(Costume costumeToUpdate , List<Integer> categoryIds, List<String> photos);

    void deleteCostume(int costumeId);
}
