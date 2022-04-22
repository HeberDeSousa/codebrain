package com.codebrain.teste.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket swaggerProdutoApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Produto").select()
				.apis(RequestHandlerSelectors.basePackage("com.codebrain.teste.controller"))
				.paths(PathSelectors.ant("/produto/**")).build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Produto API").build());
	}

	@Bean
	public Docket swaggerRankingApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Ranking").select()
				.apis(RequestHandlerSelectors.basePackage("com.codebrain.teste.controller"))
				.paths(PathSelectors.ant("/ranking/**")).build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Ranking API").build());
	}

	@Bean
	public Docket swaggerVendaApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Venda").select()
				.apis(RequestHandlerSelectors.basePackage("com.codebrain.teste.controller"))
				.paths(PathSelectors.ant("/venda/**")).build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Venda API").build());
	}

	@Bean
	public Docket swaggerVendedorApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Vendedor").select()
				.apis(RequestHandlerSelectors.basePackage("com.codebrain.teste.controller"))
				.paths(PathSelectors.ant("/vendedor/**")).build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Vendedor API").build());
	}
}
