package com.dvptest.miapp.security;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtUtil {
    private static final SecretKey key = Jwts.SIG.HS256.key().build();

    @Value("${jwt.expiration}")
    private long expirationTime;

    public String generarToken(String usuario){
        return Jwts.builder()
            .subject(usuario)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + expirationTime))
            .signWith(key)
            .compact();
    }

    public String extraerUsuario(String token){
        return extraerClaim(token, Claims::getSubject);
    }

    public boolean validarToken(String token, String usuario){
        return extraerUsuario(token).equals(usuario) && !isTokenExpirado(token);
    }

    private boolean isTokenExpirado(String token){
        return extraerClaim(token, Claims::getExpiration).before(new Date());
    }

    private <T> T extraerClaim(String token, Function<Claims, T> claimsResolver){
        Claims claims = Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .getPayload();

        return claimsResolver.apply(claims);
    }

}
