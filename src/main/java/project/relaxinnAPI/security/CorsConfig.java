package project.relaxinnAPI.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
	@Override 
	public void addCorsMappings(CorsRegistry registry) { 
		registry
			.addMapping("/**")
			.allowedOrigins("https://relax-inn-by-manali.netlify.app/"); //for prod environment
//			.allowedOrigins("http://localhost:3000/");		// for dev environment
	} 	
	
	//	If you use the latest spring-boot 2.1.6.RELEASE with a simple @RestController annotation,
	//	then you do not need to do anything, just add your index.html file under the resources/static folder for your app's home page 
	//	Above works out of the box with Spring and Tomcat and your HTTP request to the root / and is mapped automatically to the index.html file. 
	//	But if you used @EnableWebMvc annotation then you switch off that Spring Boot does for you. 
	//	In this case, you have two options:
	//		-Remove that annotation
	//		-Or you could add back the view controller that you switched off
	
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
		"classpath:/static/"
    };
	
	@Override
	public void addViewControllers(ViewControllerRegistry viewRegistry) {
		viewRegistry.addRedirectViewController("/", "index.html");
	}


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
            .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }
}