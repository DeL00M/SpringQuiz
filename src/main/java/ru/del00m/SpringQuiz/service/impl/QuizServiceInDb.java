package ru.del00m.SpringQuiz.service.impl;

import org.springframework.stereotype.Service;
import ru.del00m.SpringQuiz.domain.Quiz;
import ru.del00m.SpringQuiz.repository.QuizRepository;
import ru.del00m.SpringQuiz.service.QuizService;

import java.util.List;

@Service
public class QuizServiceInDb implements QuizService {

    private QuizRepository quizRepository;

    public QuizServiceInDb(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public List<Quiz> getAll() {
        return quizRepository.findAll();
    }

    @Override
    public List<Quiz> find(String query) {
        return query != null && !query.isEmpty() ? quizRepository.findAllByTitleLikeIgnoreCase("%" + query + "%") : quizRepository.findAll();
    }

    @Override
    public void save(Quiz quiz) {
        quizRepository.save(quiz);
    }

}
