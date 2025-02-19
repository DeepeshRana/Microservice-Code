package in.pwskill.deepesh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	public BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	/*
	 * perform authentication for the given input by loading the data from database
	 * using BCryptpasswordEncoder
	 */
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		return daoAuthenticationProvider;
	}

	// 1. Authorization

	@Bean
	public SecurityFilterChain configurePath(HttpSecurity http) throws Exception {

		return http.authorizeHttpRequests(

				request -> request.requestMatchers("/", "/home").permitAll().requestMatchers("/hello").authenticated()
						.requestMatchers("/admin").hasAnyAuthority("ADMIN").requestMatchers("/customer")
						.hasAnyAuthority("CUSTOMER").requestMatchers("/user/**").permitAll().anyRequest().permitAll()

		).formLogin(form -> form.loginPage("/login").permitAll()).logout(logout -> logout.permitAll()).build();
	}

}
