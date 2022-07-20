package project.relaxinnAPI.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig{
		// Configuring HttpSecurity - This allows us to configure our AUTHORIZATION part (URL access controls)
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{	        
			http
			.csrf()
			.disable()
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/properties/**").permitAll()
			.antMatchers("/propertyTypes/**").permitAll()			
			.antMatchers("/users/**").permitAll()
			.antMatchers("/auth").permitAll()
			.antMatchers("/register").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
			
			return http.build();
		}
		
		// Spring @Bean annotation tells that a method produces a bean to be managed by the Spring container. 
		// It is a method-level annotation. During Java configuration ( @Configuration ), 
		// the method is executed and its return value is registered as a bean within a BeanFactory
		// BCrypt Password Encoder 
		@Bean
		public BCryptPasswordEncoder bCryptPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
		// this is our AuthenticationManager		
		@Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }
}