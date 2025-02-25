package ru.costumes.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.costumes.rental.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailAndPassword(String email, String password);
}
