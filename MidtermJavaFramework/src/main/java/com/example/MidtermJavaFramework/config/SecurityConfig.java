package com.example.MidtermJavaFramework.config;
import com.example.MidtermJavaFramework.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccountServiceImpl accountService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
//                 http://localhost:8080/students/create?username=admin&password=123
                .antMatchers("/accounts/hello").hasAuthority("ADMIN")
//                .antMatchers("/accounts").permitAll()
//                .antMatchers("/accounts/create").permitAll()
//                .antMatchers("/products/**").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin()
                .and()
                // What's the authenticationManager()?
                // An object provided by WebSecurityConfigurerAdapter, used to authenticate the user passing user's credentials
                // The filter needs this auth manager to authenticate the user.
                .addFilter(new com.example.MidtermJavaFramework.config.JwtTokenGeneratorFilter(authenticationManager()))
                // Add a filter to validate the tokens with every request
                .addFilterAfter(new com.example.MidtermJavaFramework.config.JwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountService)
                .passwordEncoder(passwordEncoder());
    }
}
