package ru.del00m.SpringQuiz.service.impl;

import org.springframework.stereotype.Service;
import ru.del00m.SpringQuiz.domain.Quiz;
import ru.del00m.SpringQuiz.service.QuizService;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceInMemory  implements QuizService {

    private ArrayList<Quiz> quizzes = new ArrayList<>();
    @Override
    public List<Quiz> getAll() {
        return quizzes;
    }
}
