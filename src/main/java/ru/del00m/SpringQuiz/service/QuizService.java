package ru.del00m.SpringQuiz.service;

import ru.del00m.SpringQuiz.domain.Quiz;;

import java.util.List;

public interface QuizService {
    public List<Quiz> getAll();
    public List<Quiz> find(String query);
    public void save(Quiz quiz);
}
