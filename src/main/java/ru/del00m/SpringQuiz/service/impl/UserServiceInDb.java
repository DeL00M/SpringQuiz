package ru.del00m.SpringQuiz.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.del00m.SpringQuiz.repository.UserRepository;
import ru.del00m.SpringQuiz.service.UserService;

@Service
public class UserServiceInDb implements UserService {

    private UserRepository userRepository;

    public UserServiceInDb(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
