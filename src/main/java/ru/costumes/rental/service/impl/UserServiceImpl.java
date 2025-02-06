package ru.costumes.rental.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.costumes.rental.model.User;
import ru.costumes.rental.repository.UserRepository;
import ru.costumes.rental.service.UserService;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    @Override
    public User signIn(String email, String password) {
        User user = repository.findByEmailAndPassword(email, password);
        if (user == null) {
            throw new RuntimeException("User not found or invalid credentials");
        }
        return user;
    }

    @Override
    public User registerMe(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return repository.save(user);
    }

    @Override
    public User findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User updateMe(User user) {
        return repository.save(user);
    }
}
