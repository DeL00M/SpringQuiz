package ru.del00m.SpringQuiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {
    @GetMapping("/")
    public String quiz() {
        return "hello";
    }
}
