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
import java.nio.file.Paths;
import java.util.UUID;

@Controller
public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @Value("${img.upload.dir}")
    private String imgUploadDir;

    @Value("${static_dir.path}")
    private String staticDirPath;

    @Value("${img.path}")
    private String imgPath;

    @Value("${img.default.name}")
    private String defaultImgName;

    @GetMapping({"/"})
    public String show(@RequestParam(required = false) String query, Model model) {
        model.addAttribute("quizzes", quizService.find(query));
        model.addAttribute("imgDir", imgPath);
        model.addAttribute("imgUploadDir", imgUploadDir);
        model.addAttribute("defaultImgName", defaultImgName);
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
            File uploadDir = new File(System.getProperty("user.dir") + staticDirPath + imgPath + imgUploadDir);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            if (!img.getOriginalFilename().isEmpty()) {
                String originalFileExtension = img.getOriginalFilename().substring(img.getOriginalFilename().lastIndexOf('.'));
                String resultFileName = UUID.randomUUID().toString() + originalFileExtension;
                img.transferTo(new File(uploadDir + File.separator + resultFileName));
                quiz.setImg(resultFileName);
            }
        }
        quizService.save(quiz);
        return "addquiz";
    }
}
