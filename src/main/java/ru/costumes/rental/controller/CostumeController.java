package ru.costumes.rental.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.costumes.rental.DTO.CostumesDTO;
import ru.costumes.rental.model.Costume;
import ru.costumes.rental.service.CostumeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/costumes")
public class CostumeController {
    private CostumeService costumeService;

    @GetMapping
    private List<CostumesDTO> getCostumes() {
        return costumeService.getCostumes();
    }

    @PostMapping
    private ResponseEntity createCostume(@RequestBody CostumeRequest costumeRequest) {
        try {
            Costume costume = new Costume();
            costume.setName(costumeRequest.getName());
            costume.setPricePerDay(costumeRequest.getPricePerDay());

            Costume createdCostume = costumeService.create(costume, costumeRequest.getCategoryIds());

            return ResponseEntity.status(HttpStatus.CREATED).body(createdCostume);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Data
    public static class CostumeRequest {
        private String name;
        private Double pricePerDay;
        private List<Integer> categoryIds;
    }
}
