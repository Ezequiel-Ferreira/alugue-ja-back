package com.teste.ezequiel.alugueja.configs;


import com.teste.ezequiel.alugueja.configs.security.JWTUtil;
import com.teste.ezequiel.alugueja.configs.security.JwtAuthenticationFilter;
import com.teste.ezequiel.alugueja.configs.security.JwtAuthorizationFilter;
import com.teste.ezequiel.alugueja.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private JWTUtil jwtUtil;

    private static final String[] PUBLIC_MATCHS_GET ={
            "/filme/**",
    };

    private static final String[] IGNORE_MATCHS_GET ={
            "/v2/api-docs",
            "/configuration/ui",
            "/swagger-resources/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/swagger-ui/**", "/bus/v3/api-docs/**",
            "/webjars/**",
            "/swagger-ui-custom.html"
    };

    private static final String[] PUBLIC_MATCHS_POST ={
            "/usuario/**",
            "/login/**",
            "/authentication/**"
    };


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, PUBLIC_MATCHS_GET).permitAll()
                .antMatchers(HttpMethod.POST, PUBLIC_MATCHS_POST).permitAll()
                .antMatchers(IGNORE_MATCHS_GET).permitAll()
                .anyRequest().authenticated().and().csrf().disable().cors()
                .configurationSource( this.corsConfigurationSource()).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilter(new JwtAuthenticationFilter(this.authenticationManager(), this.jwtUtil));
        http.addFilter(new JwtAuthorizationFilter(authenticationManager(), jwtUtil, usuarioService));
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.usuarioService).passwordEncoder(bCryptPasswordEncoder());
    }
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration());
        return source;
    }

    CorsConfiguration corsConfiguration() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.setAllowedOriginPatterns(Collections.singletonList("*"));
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        return config;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
