package com.example.lab1.service.impl;

import com.example.lab1.Util.JwtUtil;
import com.example.lab1.entity.dto.request.LoginRequest;
import com.example.lab1.entity.dto.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;



    public LoginResponse login(LoginRequest loginRequest) {
         //try {
           authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );

        final String accessToken = jwtUtil.generateToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken);
        return loginResponse;
    }
}
