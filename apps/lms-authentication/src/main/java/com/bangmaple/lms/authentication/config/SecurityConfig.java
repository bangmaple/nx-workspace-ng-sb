package com.bangmaple.lms.authentication.config;

import com.bangmaple.lms.authentication.security.AuthenticationManager;
import com.bangmaple.lms.authentication.security.SecurityContextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import reactor.core.publisher.Mono;

@Configuration
@EnableReactiveMethodSecurity
@EnableWebFlux
@EnableWebFluxSecurity
@RequiredArgsConstructor
public class SecurityConfig implements WebFluxConfigurer {

  private final AuthenticationManager authenticationManager;
  private final SecurityContextRepository securityContextRepository;

  @Bean
  protected SecurityWebFilterChain configure(ServerHttpSecurity http) throws Exception {
    return http
      .exceptionHandling()
      .authenticationEntryPoint((swe, e) ->
        Mono.fromRunnable(() -> swe.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED)))
      .accessDeniedHandler((swe, e) ->
        Mono.fromRunnable(() -> swe.getResponse().setStatusCode(HttpStatus.FORBIDDEN)))
      .and()
      .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
      .csrf(ServerHttpSecurity.CsrfSpec::disable)
      .formLogin(ServerHttpSecurity.FormLoginSpec::disable)
      .authenticationManager(authenticationManager)
      .securityContextRepository(securityContextRepository)
      .authorizeExchange()
      .pathMatchers("/api/auth/signin").permitAll()
      .pathMatchers("/api/auth/signup").permitAll()
      .pathMatchers("/api/auth/forgotpwd").permitAll()
      .pathMatchers("/api/auth/logout").authenticated()
      .anyExchange().authenticated()
      .and()
      .build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
      .allowedOrigins("*")
      .allowedMethods("*")
      .allowedHeaders("*");
  }
}
