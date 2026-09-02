package fr.eni.ludotheque.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@AllArgsConstructor
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

	private JwtAuthFilter jwtAuthFilter;

	private UserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.csrf(csrf -> csrf.disable())
		//.csrf(AbstractHttpConfigurer::disable)
		// .csrf(withDefaults())
			.authorizeHttpRequests((requests) -> requests
					.requestMatchers("/api/login").permitAll()
				.requestMatchers(HttpMethod.POST, "/api/locations").hasRole("EMPLOYE")
				.anyRequest().denyAll()
			)
			//.httpBasic(Customizer.withDefaults());
				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider())
				.addFilterBefore( jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
				;

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
	    //return new BCryptPasswordEncoder();
		//return NoOpPasswordEncoder.getInstance(); //sans gestion du chiffrement
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;

	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}


}
