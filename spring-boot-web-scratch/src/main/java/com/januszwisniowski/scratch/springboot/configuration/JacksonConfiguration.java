package com.januszwisniowski.scratch.springboot.configuration;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfiguration {

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jacksonCustomizer() {
		return jackson2ObjectMapperBuilder -> {
			// Jackson Afterburner module to speed up serialization/deserialization.
			jackson2ObjectMapperBuilder.modulesToInstall(new AfterburnerModule());
			jackson2ObjectMapperBuilder.featuresToDisable(
				SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		};
	}
}
