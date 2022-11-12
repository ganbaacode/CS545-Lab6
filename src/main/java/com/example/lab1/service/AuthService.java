package com.example.lab1.service;

import com.example.lab1.entity.dto.request.LoginRequest;
import com.example.lab1.entity.dto.response.LoginResponse;

//@Service
public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
}
