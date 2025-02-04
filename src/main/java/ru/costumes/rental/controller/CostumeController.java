package ru.costumes.rental.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
