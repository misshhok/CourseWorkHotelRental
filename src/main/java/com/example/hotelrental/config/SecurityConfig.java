package com.example.hotelrental.config;

import com.example.hotelrental.infrastructure.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.method.annotation.AuthenticationPrincipalArgumentResolver;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;

    /**
     * Конфигурация доступа к URI.
     *
     * @param http - autowired
     * @return SecurityFilterChain
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests((auth) ->
                        {
                            try {
                                auth
                                        .requestMatchers("/registration/").permitAll()
                                        .requestMatchers("/").permitAll()
                                        .requestMatchers("/test/").authenticated()
                                        .requestMatchers("/rents/**").authenticated()
                                        .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                                        .requestMatchers("/v3/api-docs/**",
                                                "/swagger-ui/**").permitAll()
                                        .anyRequest().permitAll()
                                        .and()
                                        .formLogin()
                                        .loginProcessingUrl("/login")
                                        .defaultSuccessUrl("/")
                                        .and()
                                        .logout()
                                        .logoutUrl("/logout")
                                        .deleteCookies("JSESSIONID");
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                )
                .httpBasic();
        return http.build();
    }

    //  /**
//   * Создание юзера с ролью администратор.
//   *
//   * @return InMemoryUserDetailsManager
//   */
//  @Bean
//  public InMemoryUserDetailsManager userDetailsService() {
//    UserDetails user = User
//      .withUsername("admin")
//      .password(passwordEncoder().encode("pass"))
//      .roles("ADMIN")
//      .build();
//
//    return new InMemoryUserDetailsManager(user);
//  }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public AuthenticationPrincipalArgumentResolver authenticationPrincipalArgumentResolver() {
        return new AuthenticationPrincipalArgumentResolver();
    }
}
