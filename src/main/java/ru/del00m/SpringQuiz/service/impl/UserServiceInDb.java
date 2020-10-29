package ru.del00m.SpringQuiz.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.del00m.SpringQuiz.domain.Role;
import ru.del00m.SpringQuiz.domain.User;
import ru.del00m.SpringQuiz.repository.UserRepository;
import ru.del00m.SpringQuiz.service.UserService;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserServiceInDb implements UserService {

    private UserRepository userRepository;

    private ConfirmationMailSender confirmationMailSender;

    public UserServiceInDb(UserRepository userRepository, ConfirmationMailSender confirmationMailSender) {
        this.userRepository = userRepository;
        this.confirmationMailSender = confirmationMailSender;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean addUser(User user) {
        User existedUser = userRepository.findByUsername(user.getUsername());
        if (existedUser != null) {
            return false;
        }
        user.setActive(false);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Please follow this link to activate your account http://localhost:8080/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );
            confirmationMailSender.send(user.getEmail(), "Activation code", message);
        }
        return true;
    }

    @Override
    public boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);
        if (user == null) {
            return false;
        }
        user.setActivationCode(null);
        userRepository.save(user);
        return true;
    }
}
