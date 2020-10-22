package ru.del00m.SpringQuiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.del00m.SpringQuiz.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);
}
