package in.pwskill.deepesh.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// 1. Authorization
	
	@Bean
	public SecurityFilterChain configurePath(HttpSecurity http) throws Exception {
		
		return http.authorizeHttpRequests(
				
				request->request.requestMatchers("/","/home").permitAll()
								.requestMatchers("/hello").authenticated()
								.requestMatchers("/admin").hasAnyAuthority("ADMIN")
								.requestMatchers("/customer").hasAnyAuthority("CUSTOMER")
								.anyRequest().permitAll()
				
				).formLogin(form->form.loginPage("/login").permitAll())
				 .logout(logout->logout.permitAll()).build();
	}

	// 2. Authentication
	
	@Bean
	public UserDetailsService userDetailsService(DataSource datasource) {
		
		//JDBC storage and authentication using 'predefined filter'
		
		UserDetails user1  = User.withUsername("Deepesh")
				.password("$2a$12$fbBONITCeFiUJFm8/BAtS.DXAgY2UvEhxA3VR/3IlU1DxDmxrS0hS")
				.authorities("ADMIN").build();
		
		UserDetails user2  = User.withUsername("Java")
				.password("$2a$12$Sk/neli230k9xEPSw7nWkeG9iLHzcaz0Gu6eniVSY2kK.z2PhDKay")
				.authorities("CUSTOMER").build();
		
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(datasource);
		users.createUser(user1);
		users.createUser(user2);
		
		return users;
	}

}
