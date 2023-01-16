package com.example.teste.services;


import com.example.teste.entity.User;
import com.example.teste.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

////    public Optional<User> findByUser(String login) {
////        return userRepository.findByUser(login);
//    }
}
