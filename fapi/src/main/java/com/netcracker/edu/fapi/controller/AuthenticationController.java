package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.AuthToken;
import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

//AuthenticationController has API exposed to generate JWT token
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping(value = "/login")
    public ResponseEntity<AuthToken> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getLogin(),
                        user.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(new AuthToken(token, userDetails.getUsername(), userDetails.getAuthorities().toArray()[0].toString()));
    }
}
