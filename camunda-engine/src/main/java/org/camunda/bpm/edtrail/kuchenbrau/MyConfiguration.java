package org.camunda.bpm.edtrail.kuchenbrau;

import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.camunda.bpm.spring.boot.starter.configuration.Ordering;
import org.camunda.cawemo.plugin.CawemoEnginePlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
            }
        };
    }

    @Bean
    @Order(Ordering.DEFAULT_ORDER + 1)
    public static ProcessEnginePlugin cawemoEnginePlugin() {
        CawemoEnginePlugin plugin = new CawemoEnginePlugin();
        plugin.setCawemoUrl("https://cawemo.com");
        plugin.setOrganizationId("7778bb57-2be4-4d76-b5c8-6bbb6fa56a7f");
        plugin.setApiKey("81781fa935cda3213a9af0c11cb9bce126bf2133ea55b596bf007ae3c40ec579");
        plugin.setProjectName("KuchenBrau Deployments");
        plugin.setAuthMode("BASIC");
        plugin.setCustomBasicAuth(false);
//        plugin.setCustomBasicAuthUser("norbert.kuchenmeister@camunda.com");
//        plugin.setCustomBasicAuthPassword("Osk@r3ak");

        return plugin;
    }
}
