package com.placa.mae.placamae.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebFluxSecurity
public class WebSecurityConfigAdolescent {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
                    http
                            .authorizeRequests((requests) -> requests
                                    .antMatchers("/adolescents", "adolescents").permitAll()
                                    .anyRequest().authenticated()
                            )
                            .formLogin((login) -> login
                                    .loginPage("/login")
                                    .permitAll()
                            )
                            .logout((logout) -> logout.permitAll());
                    return http.build();
    }

    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();
        return new InMemoryUserDetailsManager(user);
    }
}
