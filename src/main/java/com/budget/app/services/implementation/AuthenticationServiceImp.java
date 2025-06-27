package com.budget.app.services.implementation;

import com.budget.app.config.JwtUtils;
import com.budget.app.entity.User;
import com.budget.app.exception.UserNotFoundException;
import com.budget.app.exception.WrongCredentialsException;
import com.budget.app.services.IAuthenticationService;
import com.budget.app.services.IUsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AuthenticationServiceImp implements IAuthenticationService {
    private final IUsersService usersService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @Override
    public String authenticate(String username, String password)
            throws WrongCredentialsException, UserNotFoundException {

        User user = usersService.findByUsername(username);
        if(!passwordEncoder.matches(password, user.getPassword())) throw new WrongCredentialsException();

        return jwtUtils.generateToken(username);

    }
}
