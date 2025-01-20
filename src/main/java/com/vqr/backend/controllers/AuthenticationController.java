package com.vqr.backend.controllers;

import com.vqr.backend.dtos.authentication.AuthenticationDTO;
import com.vqr.backend.dtos.login.LoginResponseDto;
import com.vqr.backend.dtos.register.RegisterDto;
import com.vqr.backend.models.UserModel;
import com.vqr.backend.repositories.UserRepository;
import com.vqr.backend.services.impl.TokenService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
        @Autowired
        private AuthenticationManager authenticationManager;
        @Autowired
        private UserRepository repository;
        @Autowired
        private TokenService tokenService;

        @PostMapping("/login")
        public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((UserModel) auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDto(token));
        }

        @PostMapping("/register")
        public ResponseEntity register(@RequestBody @Valid RegisterDto data){
            if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
            UserModel newUser = new UserModel(data.login(), encryptedPassword, data.role());
            this.repository.save(newUser);
            return ResponseEntity.ok().build();
        }
}
