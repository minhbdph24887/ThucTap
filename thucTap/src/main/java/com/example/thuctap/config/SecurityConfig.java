package com.example.thuctap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("minhbdph24887").password(getPasswordEncoder().encode("09032003")).roles("ADMIN", "USER", "GUEST")
                .and()
                .withUser("hiennttph25063").password(getPasswordEncoder().encode("123456")).roles("USER", "GUEST")
                .and()
                .withUser("User01").password(getPasswordEncoder().encode("123456")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable();

        http.authorizeHttpRequests()
//                .antMatchers("/home/admin").hasRole("ADMIN")
//                .antMatchers("/home/user").hasAnyRole("ADMIN", "USER")
//                .antMatchers("/home/authentication").authenticated()
                .anyRequest().permitAll();

        http.exceptionHandling()
                .accessDeniedPage("/auth/access/denied");

        http.formLogin()
                .loginPage("/auth/login/form")
                .loginProcessingUrl("/auth/login")
                .defaultSuccessUrl("/auth/login/success", false)
                .failureUrl("/auth/login/error")
                .usernameParameter("username")
                .passwordParameter("password");
        http.rememberMe()
                .rememberMeParameter("remember");
        http.logout()
                .logoutUrl("/auth/logout")
                .logoutSuccessUrl("/auth/logout/success");
    }
}
