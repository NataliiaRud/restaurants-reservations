package ua.study.restaurant.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import ua.study.restaurant.service.SecurityUserDetailsService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Web security Spring Boot configuration class
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private SecurityUserDetailsService securityUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/restaurant",
                                "*.css",
                                "/images/*.jpg", "/images/*.svg", "/images/*.ico",
                                "/js/*").permitAll()
                        .requestMatchers(HttpMethod.POST, "/reserve").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll())
                .csrf().disable();

        return http.build();
    }
}
