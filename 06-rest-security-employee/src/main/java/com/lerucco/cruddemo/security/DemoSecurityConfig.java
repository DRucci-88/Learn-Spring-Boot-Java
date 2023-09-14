package com.lerucco.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	// Add support for JDBC ... no more hardcoded users
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

		// Define query to retrive a user by username
		// "?" parameter value will be the user name from login
		// How to find users
		jdbcUserDetailsManager.setUsersByUsernameQuery(
				"select user_id, pw, active from members where user_id=?");

		// Define query to retrieve the authorities/roles by username
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				"select user_id, role from roles where user_id=?");
		// Tell Spring Security to use JDBC authencation with our data source (database)
		return jdbcUserDetailsManager;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

		// Authorization rules given endpoints based on role
		httpSecurity.authorizeHttpRequests(configurer -> configurer
				.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
				// .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));

		// Use HTTP Basic Authentication
		httpSecurity.httpBasic(Customizer.withDefaults());

		// Disable CSRF
		// In general, not required for stateless REST APIs that use :
		// POST, PUT, DELETE, PATCH
		httpSecurity.csrf(csrf -> csrf.disable());
		return httpSecurity.build();

	}

	// @Bean
	// public InMemoryUserDetailsManager userDetailsManager() {
	// UserDetails john = User.builder()
	// .username("john")
	// .password("{noop}john")
	// .roles("EMPLOYEE")
	// .build();

	// UserDetails mary = User.builder()
	// .username("mary")
	// .password("{noop}mary")
	// .roles("EMPLOYEE", "MANAGER")
	// .build();

	// UserDetails le = User.builder()
	// .username("le")
	// .password("{noop}le")
	// .roles("EMPLOYEE", "MANAGER", "ADMIN")
	// .build();

	// return new InMemoryUserDetailsManager(john, mary, le);
	// }

}
