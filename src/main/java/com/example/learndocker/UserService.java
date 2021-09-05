package com.example.learndocker;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> fetchAll() {
        return userRepository.findAll();
    }

    public User findById(final Long id) {
        return userRepository.findById(id)
                             .orElse(null);
    }

    public User save(final User user) {
        return userRepository.save(user);
    }

    public void delete(final User user) {
        userRepository.delete(user);
    }
}
