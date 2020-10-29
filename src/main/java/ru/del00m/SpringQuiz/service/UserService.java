package ru.del00m.SpringQuiz.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.del00m.SpringQuiz.domain.User;

public interface UserService extends UserDetailsService {
    boolean addUser(User user);
    boolean activateUser(String code);
}
