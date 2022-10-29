package com.placa.mae.placamae.security;

import com.placa.mae.placamae.domain.PeopleAdolescent;
import com.placa.mae.placamae.repository.DAOPeopleAdolescent;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationWithToken extends OncePerRequestFilter {
    private DAOPeopleAdolescent daoPeopleAdolescent;
    private TokenService tokenService;

    public AuthenticationWithToken(TokenService tokenService,
                                   DAOPeopleAdolescent daoPeopleAdolescent) {
        this.daoPeopleAdolescent = daoPeopleAdolescent;
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain filterChain) throws ServletException, IOException {

                String token = recoveryToken(request);
                boolean valid = tokenService.isTokenValid(token);

                if (valid) {
                    authenticationClient(token);
                }

                filterChain.doFilter(request, response);
    }

    private void authenticationClient (String token) {
        Long idAdolescent = tokenService.getIdAdolescent(token);
        PeopleAdolescent adolescent = daoPeopleAdolescent.findById(idAdolescent).get();
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(adolescent, null, adolescent.getAuthorities());
                     SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    private String recoveryToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
                return null;
        }

        return token.substring(7, token.length());
    }
}
