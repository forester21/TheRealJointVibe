package ru.jointvibe.mainwebservice.security;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //TODO API_AUDIENCE vs ISSUER?
    public static final String API_AUDIENCE = "JV!";
    public static final String ISSUER = "JV!";
    //TODO not so secret place to store secret:)
    public static final String SECRET = "secret";

    //TODO how about CORS HERE?
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
//        configuration.setAllowCredentials(true);
//        configuration.addAllowedHeader("Authorization");
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        JwtWebSecurityConfigurer
                .forHS256(API_AUDIENCE, ISSUER, SECRET.getBytes())
                .configure(http)
                .authorizeRequests()
                // TEST METHODS
                .antMatchers(HttpMethod.GET, "/test/api/public").permitAll()
                .antMatchers(HttpMethod.GET, "/test/api/private").authenticated()
                // REAL METHODS
                .antMatchers(HttpMethod.GET, "/api/account/userInfo").authenticated();
    }
}
