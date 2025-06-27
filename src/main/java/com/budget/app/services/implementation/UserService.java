package com.budget.app.services.implementation;

import com.budget.app.entity.User;
import com.budget.app.exception.UserNotFoundException;
import com.budget.app.repository.UserRepository;
import com.budget.app.services.IUsersService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUsersService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public long save(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return userRepository.save(user).getId();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long userId) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty()) throw new UserNotFoundException(userId);

        return user.get();
    }

    @Override
    public User findByUsername(String username) throws UserNotFoundException {
       Optional<User>  user = userRepository.findByUsername(username);

       if(user.isEmpty()) throw new UserNotFoundException(username);

       return user.get();
    }

    @Override
    public User getCurrentUser() throws UserNotFoundException {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        return this.findByUsername(userName);
    }
}
