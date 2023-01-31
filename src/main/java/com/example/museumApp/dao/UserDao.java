package com.example.museumApp.dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDao {

    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User(
                    "user@email.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
            ),
            new User(
                    "user@email.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            ),
            new User(
                    "2",
                    "2",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            ),
            new User(
                    "3",
                    "3",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            ),
            new User(
                    "4",
                    "4",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            ),
            new User(
                    "5",
                    "5",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            ),
            new User(
                    "6",
                    "6",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            ),
            new User(
                    "7",
                    "7",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            ),
            new User(
                    "8",
                    "8",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            ),
            new User(
                    "9",
                    "9",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            )
    );

    public UserDetails findUserByEmail(String email) {
        return APPLICATION_USERS
                .stream()
                .filter(u -> u.getUsername().equals(email))
                .findFirst()
                .orElseThrow(()->new UsernameNotFoundException("No user waas found"));
    }
}
