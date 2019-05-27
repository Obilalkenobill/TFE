/*package com.example.demo.controller;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dal.entities.User;
import com.example.demo.dal.services.UserService;

@RestController
@RequestMapping("/token")
@CrossOrigin(origins="http://localhost:4200")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity<UsernamePasswordAuthenticationToken> register(@RequestBody User user) throws AuthenticationException {

        final org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User iser = userService.loadUserByUsername(user.getUsername());
        return ResponseEntity.ok(new UsernamePasswordAuthenticationToken(user,iser,iser.getAuthorities()));
    }

}*/
