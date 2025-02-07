package ru.costumes.rental.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.costumes.rental.model.Status;
import ru.costumes.rental.service.StatusService;

import java.util.List;

@RestController
@RequestMapping("api/v1/statuses")
@AllArgsConstructor
public class StatusController {
    private final StatusService statusService;

    @GetMapping
    public List<Status> getStatuses() {
        return statusService.getStatuses();
    }
}
