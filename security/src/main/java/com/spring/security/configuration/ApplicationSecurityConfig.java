package com.spring.security.configuration;

import com.spring.security.permissions.ApplicationUserPermission;
import com.spring.security.permissions.ApplicationUserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static com.spring.security.permissions.ApplicationUserRole.ADMIN;
import static com.spring.security.permissions.ApplicationUserRole.STUDENT;


@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests((authz) -> authz.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

    protected void Configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.
                authorizeHttpRequests()
                .requestMatchers("").hasRole(STUDENT.name())
                .anyRequest();
    }

    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails rakeshUser = User.builder()
                .username("rakesh")
                .password(passwordEncoder().encode("root"))
                //.roles(STUDENT.name())
                .autho
                .build();

        UserDetails lindaUser = User.builder()
                .username("linda")
                .password(passwordEncoder().encode("root"))
                //.roles(ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(
                rakeshUser,
                lindaUser
        );
    }


}
