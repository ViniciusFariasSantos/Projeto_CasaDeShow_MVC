package com.br.gft.gestaoShow.openApi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
	
	
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.br.gft.gestaoShow.resources"))
					.build()
				.apiInfo(apiInfo())
				.tags(new Tag("Casa",  "Gerencia as casas"), new Tag("Evento","Gerencia os eventos"),new Tag("Usuario","Gerencia os usuarios"),new Tag("Venda","Gerencia as vendas"));
		
		//caso eu queira utilizar mas de um pacote, só eu utlizar a linha de codigo abaixo
		//.apis(Predicates.and(
		//RequestHandlerSelectors.basePackage("com.br.gft.gestaoShow.primeiro.pacote")
		//RequestHandlerSelectors.basePackage("com.br.gft.gestaoShow.segundo.pacote")))
		//.build();
		
		
	}
	
	public ApiInfo apiInfo() {
		 return new ApiInfoBuilder()
				 .title("Casa de Show API")
				 .description("API aberta para clientes ")
				 .version("1")
				 .contact(new Contact("GFT", "spviniciusfariassantos@gmail.com", null))
				 .build()
				 ;
	}
	
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
		 .addResourceLocations("classpath:/META-INF/resources/");
	
		registry.addResourceHandler("/webjars/**")
		 .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}


}
