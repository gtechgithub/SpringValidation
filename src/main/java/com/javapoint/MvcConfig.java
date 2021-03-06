package com.javapoint;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.javapoint" )
public class MvcConfig extends WebMvcConfigurerAdapter{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry register)
	{
		register.addResourceHandler("/resources/**","/resources/");
	}
	
	@Bean 
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configure) {
		configure.enable();
	}
	

	 @Bean(name = "localeResolver")
     public CookieLocaleResolver localeResolver() {
             CookieLocaleResolver localeResolver = new CookieLocaleResolver();
             Locale defaultLocale = new Locale("en");
             localeResolver.setDefaultLocale(defaultLocale);
             return localeResolver;
     }

     @Bean
     public ReloadableResourceBundleMessageSource messageSource() {
             ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
             messageSource.setBasename("classpath:messages");
             messageSource.setCacheSeconds(10); //reload messages every 10 seconds
             return messageSource;
     }
}
