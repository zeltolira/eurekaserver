package com.lira.eurekaserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // Desabilita CSRF para simplificar, ajuste conforme necessário
                .authorizeRequests(authorize -> authorize
                        .antMatchers("/eureka/**").permitAll()  // Permite todos os acessos para URLs do Eureka
                        .anyRequest().authenticated()  // Exige autenticação para todas as outras requisições
                )
                .httpBasic();  // Utiliza autenticação básica

        return http.build();
    }
}
