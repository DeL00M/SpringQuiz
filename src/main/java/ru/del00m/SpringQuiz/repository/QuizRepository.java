package ru.del00m.SpringQuiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.del00m.SpringQuiz.domain.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
