package ru.del00m.SpringQuiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {
    @GetMapping({"/", "quiz"})
    public String quiz(Model model) {
        return "quiz";
    }
}
