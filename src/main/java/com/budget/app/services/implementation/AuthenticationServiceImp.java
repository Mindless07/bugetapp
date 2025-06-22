package com.budget.app.services.implementation;

import com.budget.app.config.JwtUtils;
import com.budget.app.entity.User;
import com.budget.app.services.IAuthenticationService;
import com.budget.app.services.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationServiceImp implements IAuthenticationService {
    @Autowired
    IUsersService usersService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtUtils jwtUtils;

    @Override
    public String authenticate(String username, String password) throws Exception {

        User user = usersService.findByUsername(username);
        if(!passwordEncoder.matches(password, user.getPassword())) throw new Exception("Wrong credentials");

        return jwtUtils.generateToken(username);



    }
}
