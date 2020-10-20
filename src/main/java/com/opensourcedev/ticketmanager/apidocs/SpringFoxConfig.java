package com.opensourcedev.ticketmanager.apidocs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Component
@PropertySource("classpath:application.yml")
@EnableSwagger2
//@EnableWebMvc
public class SpringFoxConfig {


    @Value("${api.common.version}")
    private String apiVersion;
    @Value("${api.common.title}")
    private String apiTitle;
    @Value("${api.common.description}")
    private String apiDescription;
    @Value("${api.common.termsOfServiceUrl}")
    private String apiTermsOfServiceUrl;
    @Value("${api.common.license}")
    private String apiLicense;
    @Value("${api.common.licenseUrl}")
    private String apiLicenseUrl;
    @Value("${api.common.contact.name}")
    private String apiContactName;
    @Value("${api.common.contact.url}")
    private String apiContactUrl;
    @Value("${api.common.contact.email}")
    private String apiContactEmail;


    @Bean
    public Docket apiDocumentation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                    .globalResponseMessage(RequestMethod.GET, Collections.emptyList())
                    .apiInfo(new ApiInfo(
                            apiTitle,
                            apiDescription,
                            apiVersion,
                            apiLicenseUrl,
                        new Contact( apiContactName, apiContactUrl,apiContactEmail),
                            apiLicense,
                            apiTermsOfServiceUrl,
                        Collections.emptyList()
                    ));
    }

}
