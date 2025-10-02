package com.mika.demo.security;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // --- FIX: Explicitly permit access to public paths and resources ---
        http.authorizeHttpRequests(auth -> auth
                // Allow access to static resources (CSS, JS, images)
                // Note: If you use the root path '/' for your home page, you may need to permit
                // that too.
                .requestMatchers("/webjars/**", "/css/**", "/js/**", "/images/**").permitAll()
                // Allow access to login, logout, and error pages
                .requestMatchers("/login", "/logout", "/error").permitAll()
                // Allow H2 console for development (since you enable it in
                // application.properties)
                .requestMatchers("/h2-console/**").permitAll()
                // All other requests must be authenticated
                .anyRequest().authenticated());

        http.formLogin(withDefaults());

        // We can remove these headers/frameOptions related lines if H2 console is not
        // used in production,
        // but keeping them for now as you explicitly used them for H2/JSP
        // compatibility.
        http.csrf(csrf -> csrf.disable());
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Move the code below to UserService

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails1 = createNewUser("John Doe", "password");
        UserDetails userDetails2 = createNewUser("Jane Doe", "password");
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    public UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username(username)
                .password(password)
                .roles("USER", "ADMIN").build();
        return userDetails;
    }

}
