package com.demo.example.config;

import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.ExposureConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;


public class RestConfig implements RepositoryRestConfigurer {
	@Override
    public void configureRepositoryRestConfiguration(RepositoryRestMvcAutoConfiguration restConfig,
      CorsRegistry cors) {
        ExposureConfiguration config = restConfig.getExposureConfiguration();
	}
	

}
