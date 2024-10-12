package dev.gustavorh.gestionmicrofinanzas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(HttpMethod.GET, "/api/usuarios").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/usuarios/registrar").permitAll()
                        .anyRequest().authenticated())
                        .csrf(AbstractHttpConfigurer::disable)
                        .sessionManagement(mgmt ->
                                mgmt.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .build();
    }
}
