package ru.del00m.SpringQuiz.controller;

import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import ru.del00m.SpringQuiz.domain.Quiz;
import ru.del00m.SpringQuiz.domain.User;
import ru.del00m.SpringQuiz.service.QuizService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class QuizController implements HandlerExceptionResolver {

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

    @GetMapping("/quiz/add")
    public String add(Model model) {
        return "addquiz";
    }

    @PostMapping("/quiz/add")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('USER')")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam("img") MultipartFile img,
            Model model) throws IOException {
            Quiz quiz = new Quiz(title, description, user);
            if (!img.isEmpty()) {
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
            return "redirect:/addquiz";
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView("addquiz");
        if (e instanceof MaxUploadSizeExceededException) {
            modelAndView.getModel().put("message", "The file size must be less or equal 1MB");
        }
        return modelAndView;
    }
}
