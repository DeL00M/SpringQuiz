package ru.del00m.SpringQuiz.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.del00m.SpringQuiz.domain.Quiz;
import ru.del00m.SpringQuiz.repository.QuizRepository;
import ru.del00m.SpringQuiz.service.QuizService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class QuizController {

    private QuizRepository quizRepository;

    @Value("${img.upload.dir}")
    private String imgUploadDir;

    @Value("${static_dir.path}")
    private String staticDirPath;

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
    public String add(@RequestParam String title, @RequestParam String description, @RequestParam("img") MultipartFile img, Model model) throws IOException {
        Quiz quiz = new Quiz(title, description);
        if (img != null) {
            File uploadDir = new File(new File("").getAbsolutePath() + staticDirPath + imgUploadDir);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "_" + img.getOriginalFilename();
            img.transferTo(new File(uploadDir + "/" + resultFileName));
            quiz.setImg(imgUploadDir + resultFileName);
        }
        quizRepository.save(quiz);
        return "addquiz";
    }
}
