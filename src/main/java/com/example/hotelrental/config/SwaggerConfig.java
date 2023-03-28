package com.example.hotelrental.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import java.util.List;

public class SwaggerConfig {

  @Bean
  public OpenAPI customOpenApi(
    @Value("${application-description}") String appDescription,
    @Value("${application-version}") String appVersion) {
    return new OpenAPI()
      .info(
        new Info()
          .title("Спецификация OpenAPI для сервиса аренды номера отеля")
          .version(appVersion)
          .description(appDescription)
          .license(new License().name("Apache 2.0").url("http://springdoc.org"))
          .contact(new Contact().name("имя").email("почта@gmail.com")))
      .servers(List.of(new Server().url("http://localhost:8080").description("Dev service")));
  }
}
