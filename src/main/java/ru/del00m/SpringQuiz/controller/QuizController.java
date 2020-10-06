package ru.del00m.SpringQuiz.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.del00m.SpringQuiz.service.QuizService;

@Controller
public class QuizController {

    private QuizService  quizService;

    public QuizController(@Qualifier ("QuizServiceInDb") QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping({"/", "quiz"})
    public String quiz(Model model) {
        return "quiz";
    }
}
