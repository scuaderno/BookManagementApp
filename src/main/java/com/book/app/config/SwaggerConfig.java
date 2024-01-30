package com.book.app.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

	private static Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);
	
	@Value("${swagger.app.relativepath}")
	private String relativePath;
	
	private final ServletContext servletContext;

	@Autowired
	public SwaggerConfig(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Bean
	public LinkDiscoverers discoverers() {
		List<LinkDiscoverer> plugins = new ArrayList<>();
		plugins.add(new CollectionJsonLinkDiscoverer());
		return new LinkDiscoverers(SimplePluginRegistry.create(plugins));

	}

	@Bean
	public Docket api() {
		logger.debug("relativePath::" + this.relativePath);
		return (new Docket(DocumentationType.SWAGGER_2)).pathProvider(new RelativePathProvider(servletContext) {
			@Override
			public String getApplicationBasePath() {
				return relativePath;
			}
		}).apiInfo(apiInfo()).groupName("jsonconverter").select().apis(RequestHandlerSelectors.any())
				.paths(getPaths()).build();
	}

	private Predicate<String> getPaths() {
		return PathSelectors.ant("/**");
	}

	private ApiInfo apiInfo() {
		return (new ApiInfoBuilder()).title("Book Management Service")
				.description(
						"Book Management Service for Record Tracking")
				.version("1.1.1").license("SCuaderno").build();
	}


}
