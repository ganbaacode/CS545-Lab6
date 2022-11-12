package com.example.lab1.controller;


import com.example.lab1.entity.User;
import com.example.lab1.entity.dto.request.LoginRequest;
import com.example.lab1.service.UserService;
import com.example.lab1.service.impl.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequiredArgsConstructor
public class AuthController {


    private final AuthServiceImpl authService;
    private final UserService userService;

    @PostMapping("authenticate")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("register")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }


}
