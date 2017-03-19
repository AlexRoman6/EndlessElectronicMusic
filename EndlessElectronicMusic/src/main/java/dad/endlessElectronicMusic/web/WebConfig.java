package dad.endlessElectronicMusic.web;

import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.Bean;		
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.web.servlet.ViewResolver;		
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer;		
//import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver;		

@EnableWebMvc
@Configuration
@EntityScan("dad.endlessElectronicMusic.entidades")
@ComponentScan({ "dad.endlessElectronicMusic.web" })
@EnableJpaRepositories("dad.endlessElectronicMusic.entidades")
public class WebConfig extends WebMvcConfigurerAdapter {

	/*
	 * 
	 * 
	 * //Modifica la ubicación de los templates para moustache // If view
	 * "hello" is returned, Mustache temple will be
	 * '/static/templates/hello.html'
	 * 
	 * @Bean public ViewResolver viewResolver() { ScriptTemplateViewResolver
	 * viewResolver = new ScriptTemplateViewResolver();
	 * viewResolver.setPrefix("/static/templates/");
	 * viewResolver.setSuffix(".html"); return viewResolver; }
	 */
	// add static resources like js or css
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/upload/**").addResourceLocations("/upload/");
	}

}