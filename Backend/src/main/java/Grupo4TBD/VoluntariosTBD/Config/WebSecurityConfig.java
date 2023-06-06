package Grupo4TBD.VoluntariosTBD.Config;

import Grupo4TBD.VoluntariosTBD.Filters.JwtAuthenticationFilter;
import Grupo4TBD.VoluntariosTBD.Filters.JwtAuthorizationFilter;
import lombok.AllArgsConstructor;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class WebSecurityConfig {


  private final UserDetailsService userDetailsService;
  private final JwtAuthorizationFilter jwtAuthorizationFilter;

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter();

    http.csrf().disable();
    http.cors().configurationSource(corsConfigurationSource());
    http.authorizeHttpRequests(authz -> authz
            .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
            .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
            .anyRequest().authenticated()
    );
    //http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");
    http.addFilter(jwtAuthenticationFilter).addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    return http.build();
  }

  @Bean
  AuthenticationManager authManager(HttpSecurity http) throws Exception {
    return http.getSharedObject(AuthenticationManagerBuilder.class)
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder())
            .and()
            .build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000/")); // Permitir solicitudes desde cualquier origen
    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Permitir los métodos HTTP especificados
    configuration.setAllowedHeaders(Arrays.asList("Origin", "Authorization", "Content-Type", "X-Auth-Token")); // Permitir los encabezados especificados
    configuration.setMaxAge(3600L); // Establecer el tiempo máximo en segundos que las respuestas preflight pueden ser almacenadas en caché
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

}
