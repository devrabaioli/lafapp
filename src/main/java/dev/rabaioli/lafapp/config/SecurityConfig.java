package dev.rabaioli.lafapp.config;

import java.util.Arrays;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
	
		  return http
	                .httpBasic().disable()
	                .csrf(AbstractHttpConfigurer::disable)
	                .sessionManagement(
	            		session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	                .authorizeHttpRequests(
	                    authorizeHttpRequests -> authorizeHttpRequests
	                        .requestMatchers(
	                        	"/**",
	                        	"/h2-console/**",
								"/losts/**",
								"/categories/**",
	                    		"/clients/**",
	                    		"/pedidos/**"
	                		).permitAll()
                            .requestMatchers("/api/**").authenticated()
	                        .requestMatchers("/users").denyAll()
	                )
	                .cors()
	                
	                .and().csrf().ignoringRequestMatchers("/h2-console/**")
	                .and().headers().frameOptions().sameOrigin()
	                .and()

	              // .apply(new JwtConfigurer(tokenProvider))
	              //  .and()
	                .build();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}