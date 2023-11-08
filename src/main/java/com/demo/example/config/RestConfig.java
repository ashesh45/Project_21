package com.demo.example.config;

import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfigurer;
import org.springframework.data.rest.core.mapping.ExposureConfiguration; // Add this import




public class RestConfig implements RepositoryRestConfigurer {
	
	@Override
    public void configureRepositoryRestConfiguration(RepositoryRestMvcAutoConfiguration restConfig,
      CorsRegistry cors) {
        ExposureConfiguration config = restConfig.getExposureConfiguration();
	}
	

}
