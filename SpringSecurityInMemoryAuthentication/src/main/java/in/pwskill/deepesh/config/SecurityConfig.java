package in.pwskill.deepesh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	// 1. Authorization
	
	@Bean
	public SecurityFilterChain configurePath(HttpSecurity http) throws Exception {
		
		return http.authorizeHttpRequests(
				
				request->request.requestMatchers("/","/home").permitAll()
								.requestMatchers("/hello").authenticated()
								.anyRequest().permitAll()
				
				).formLogin(form->form.loginPage("/login").permitAll())
				 .logout(logout->logout.permitAll()).build();
	}

	// 2. Authentication
	
	@Bean
	public UserDetailsService userDetailsService() {

		System.out.println("SpringConfig.userDetials() :: Inmemory Data....");
		UserDetails user1 = User.withDefaultPasswordEncoder().username("Deepesh").password("deepesh").build();
		UserDetails user2 = User.withDefaultPasswordEncoder().username("Java").password("java").build();
		return new InMemoryUserDetailsManager(user1,user2);
	}

}
