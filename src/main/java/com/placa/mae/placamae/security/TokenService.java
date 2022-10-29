package com.placa.mae.placamae.security;

import com.placa.mae.placamae.domain.PeopleAdolescent;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    @Value("${adolescent.jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication) {
        PeopleAdolescent logged = (PeopleAdolescent) authentication.getPrincipal();
        Date today = new Date();

        return Jwts.builder()
                .setIssuer("API PlacaMae")
                .setSubject(String.valueOf(logged.getAdolescentId()))
                .setIssuedAt(today)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isTokenValid (String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);

            return true;

        } catch (Exception exception) {
            return false;
        }
    }

    public Long getIdAdolescent (String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();

        return Long.parseLong(claims.getSubject());
    }
}
