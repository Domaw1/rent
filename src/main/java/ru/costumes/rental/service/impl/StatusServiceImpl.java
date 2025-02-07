package ru.costumes.rental.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.costumes.rental.model.Status;
import ru.costumes.rental.repository.StatusRepository;
import ru.costumes.rental.service.StatusService;

import java.util.List;

@Service
@AllArgsConstructor
public class StatusServiceImpl implements StatusService {
    private StatusRepository statusRepository;
    @Override
    public List<Status> getStatuses() {
        return statusRepository.findAll();
    }
}
