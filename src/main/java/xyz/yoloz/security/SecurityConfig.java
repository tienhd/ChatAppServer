package xyz.yoloz.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import xyz.yoloz.util.Constants;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebMvcSecurity
@EnableScheduling
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.
//                csrf().disable().
//                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
//                and().
//                    authorizeRequests().
//                    antMatchers(publicEndpoints()).hasAuthority("ROLE_ANONYMOUS").
//                    antMatchers(apiEndpoints()).hasAuthority("ROLE_USER").
//                    anyRequest().authenticated().
//                and().
//                    anonymous().disable().
//                    exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint());
        http.authorizeRequests().antMatchers(publicEndpoints()).permitAll();
        http.authorizeRequests().antMatchers(apiEndpoints()).hasAnyAuthority(hasAccessAuthority());
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint());
        http.addFilterBefore(new AuthenticationFilter(authenticationManager()), BasicAuthenticationFilter.class);
    }

    private String[] apiEndpoints() {
        return new String[]{ApiController.API_V1_ENDPOINT + "/*"};
    }

    private String[] publicEndpoints() {
        return new String[]{ApiController.AUTHENTICATE_URL + "/*", ApiController.METRIC_ENDPOINT + "/*"};
    }

    private String[] hasAccessAuthority() {
        return new String[]{Constants.USER_ROLE};
    }

    @Bean
    public TokenService tokenService() {
        return new TokenService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(tokenAuthenticationProvider())
                .authenticationProvider(usernamePasswordAuthenticationProvider());
    }

    @Bean
    public AuthenticationProvider tokenAuthenticationProvider() {
        return new TokenAuthenticationProvider(tokenService());
    }

    @Bean
    public AuthenticationProvider usernamePasswordAuthenticationProvider() {
        return new UsernamePasswordAuthenticationProvider(tokenService(), externalServiceAuthenticator());
    }

    @Bean
    public ExternalServiceAuthenticator externalServiceAuthenticator() {
        return new ExternalAuthenticationService();
    }

    @Bean
    public AuthenticationEntryPoint unauthorizedEntryPoint() {
        return (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}