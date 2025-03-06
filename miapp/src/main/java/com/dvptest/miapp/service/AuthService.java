package com.dvptest.miapp.service;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthService implements UserDetailsService{
    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException{
        if(!usuario.equals("admin")){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new User("admin", "{noop}password", Collections.emptyList());
    }
}
