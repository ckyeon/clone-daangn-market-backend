package com.thegreat.clonedaangnmarket.config;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientPropertiesRegistrationAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.JdbcOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final JdbcTemplate jdbcTemplate;

  private final OAuth2ClientProperties oAuth2ClientProperties;

  @Bean
  public ClientRegistrationRepository clientRegistrationRepository() {
    Map<String, ClientRegistration> clientRegistrations = OAuth2ClientPropertiesRegistrationAdapter
      .getClientRegistrations(oAuth2ClientProperties);
    return new InMemoryClientRegistrationRepository(clientRegistrations);
  }

  @Bean
  public OAuth2AuthorizedClientService oAuth2AuthorizedClientService() {
    return new JdbcOAuth2AuthorizedClientService(jdbcTemplate, clientRegistrationRepository());
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.oauth2Login()
      .authorizedClientService(oAuth2AuthorizedClientService());

    http.authorizeHttpRequests()
      .anyRequest()
      .authenticated();

    return http.build();
  }
}