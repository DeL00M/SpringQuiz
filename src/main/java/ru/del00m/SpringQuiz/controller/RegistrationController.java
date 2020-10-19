package ru.del00m.SpringQuiz.controller;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.del00m.SpringQuiz.domain.Role;
import ru.del00m.SpringQuiz.domain.User;
import ru.del00m.SpringQuiz.repository.UserRepository;

import java.util.Collections;


@Controller
public class RegistrationController {

    private UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value="/register")
    public  String registration(){
        return "registration";
    }
    
    @PostMapping(value="/register")
    public String newUser(User user, Model model) {
        User existedUser = userRepository.findByUsername(user.getUsername());
        if (existedUser != null ) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }
}
