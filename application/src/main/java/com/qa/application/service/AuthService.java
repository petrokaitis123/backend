package com.qa.application.service;

import com.qa.application.controller.payload.request.SigninRequest;
import com.qa.application.controller.payload.request.SignupRequest;
import com.qa.application.controller.payload.response.JwtResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<JwtResponse> signinUser(SigninRequest signinRequest);
    ResponseEntity<?> signupUser(SignupRequest signUpRequest);
}
