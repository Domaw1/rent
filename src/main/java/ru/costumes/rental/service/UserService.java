package ru.costumes.rental.service;

import ru.costumes.rental.model.User;

public interface UserService {
    User signIn(String email, String password);
    User registerMe(User user);
    User findById(int id);
    User updateMe(User user);
}
