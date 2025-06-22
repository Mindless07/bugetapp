package com.budget.app.services.implementation;

import com.budget.app.dto.UserDTO;
import com.budget.app.entity.User;
import com.budget.app.repository.UserRepository;
import com.budget.app.services.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUsersService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public long save(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return userRepository.save(user).getId();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long userId) throws Exception {
        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty()) throw new Exception("No User found");

        return user.get();
    }
}
