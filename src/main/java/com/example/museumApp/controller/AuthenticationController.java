//package com.example.museumApp.controller;
//
//import com.example.museumApp.config.JwtUtil;
//import com.example.museumApp.dao.UserDao;
//import com.example.museumApp.dto.AuthenticationRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/auth")
//public class AuthenticationController {
//
//  private final AuthenticationManager authenticationManager;
//  private final UserDao userDao;
//  private final JwtUtil jwtUtil;
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<String> authenticate(
//            @RequestBody AuthenticationRequest request
//    ) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
//        );
//        final UserDetails user = userDao.findUserByEmail(request.getEmail());
//        if(user != null) {
//            return ResponseEntity.ok(jwtUtil.generateToken(user));
//        }
//
//        return ResponseEntity.status(400).body("An error has occurred");
//    }
//}
