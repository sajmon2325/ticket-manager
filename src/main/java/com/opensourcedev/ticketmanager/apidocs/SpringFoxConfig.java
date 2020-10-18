package com.opensourcedev.ticketmanager.apidocs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.*;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Component
@PropertySource("classpath:springFoxdocumentation.yml")
@EnableSwagger2
@EnableWebMvc
public class SpringFoxConfig implements WebMvcConfigurer  {

    @Value("${api.common.version}")
    private static String apiVersion;
    @Value("${api.common.title}")
    private static String apiTitle;
    @Value("${api.common.description}")
    private static String apiDescription;
    @Value("${api.common.termsOfServiceUrl}")
    private static String apiTermsOfServiceUrl;
    @Value("${api.common.license}")
    private static String apiLicense;
    @Value("${api.common.licenseUrl}")
    private static String apiLicenseUrl;
    @Value("${api.common.contact.name}")
    private static String apiContactName;
    @Value("${api.common.contact.url}")
    private static String apiContactUrl;
    @Value("${api.common.contact.email}")
    private static String apiContactEmail;



    @Bean
    public Docket apiDocumentation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                    .globalResponseMessage(RequestMethod.GET, Collections.emptyList())
                    .apiInfo(new ApiInfo(
                        apiVersion,
                        apiTitle,
                        apiDescription,
                        apiTermsOfServiceUrl,
                        new Contact( apiContactName, apiContactUrl,apiContactEmail),
                        apiLicense,
                        apiLicenseUrl,
                        Collections.emptyList()
                    ));
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
