package com.example.lab1.service.impl;

import com.example.lab1.Util.JwtUtil;
import com.example.lab1.entity.dto.request.LoginRequest;
import com.example.lab1.entity.dto.request.RefreshTokenRequest;
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
        final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());

        var loginResponse = new LoginResponse(accessToken,refreshToken);
        return loginResponse;
    }


    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {

        boolean isRefreshTokenValid = jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());
        boolean isAccessTokenValid = jwtUtil.validateToken(refreshTokenRequest.getAccessToken());
        System.out.println(isAccessTokenValid);
        if (isRefreshTokenValid && isAccessTokenValid) {

            var isAccessTokenExpired = jwtUtil.isTokenExpired(refreshTokenRequest.getAccessToken());
            if(isAccessTokenExpired)
                System.out.println("ACCESS TOKEN IS EXPIRED"); // TODO Renew is this case
            else
                System.out.println("ACCESS TOKEN IS NOT EXPIRED");
            final String accessToken = jwtUtil.doGenerateToken(  jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());

            return loginResponse;
        }
        return new LoginResponse();
    }
}
