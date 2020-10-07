package ru.del00m.SpringQuiz.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.del00m.SpringQuiz.domain.Quiz;
import ru.del00m.SpringQuiz.repository.QuizRepository;
import ru.del00m.SpringQuiz.service.QuizService;

@Controller
public class QuizController {

    private QuizRepository quizRepository;

    public QuizController(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @GetMapping({"/", "quiz"})
    public String show(Model model) {
        model.addAttribute("quizzes", quizRepository.findAll());
        return "quiz";
    }

    @GetMapping("/addquiz")
    public String add(Model model) {
        return "addquiz";
    }

    @PostMapping("/addquiz")
    public String add(@RequestParam String title, @RequestParam String description, Model model) {
        Quiz quiz = new Quiz(title, description);
        quizRepository.save(quiz);
        return "addquiz";
    }
}
