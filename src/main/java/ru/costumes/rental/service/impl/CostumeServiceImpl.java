package ru.costumes.rental.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.costumes.rental.DTO.CostumesDTO;
import ru.costumes.rental.model.Booking;
import ru.costumes.rental.model.Costume;
import ru.costumes.rental.repository.BookingRepository;
import ru.costumes.rental.repository.CostumeRepository;
import ru.costumes.rental.service.CostumeService;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CostumeServiceImpl implements CostumeService {
    private CostumeRepository costumeRepository;
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
}
