package pl.sda.arppl4.spring_rental.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SpringfoxConfig {
    @Bean
    public Docket apiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfo(
                        "Moje Drugie API",
                        "Moje drugie A. P. I.",
                        "0.9999",
                        null,
                        new Contact("Ktos", null, "ktos@gmail.com"),
                        null,
                        null,
                        new ArrayList<>()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("pl.sda.arppl4.spring_rent.controller"))
                .paths(PathSelectors.ant("/api/**"))
                .build();
    }
}
