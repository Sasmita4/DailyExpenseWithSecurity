package com.daily.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

@Configuration
@EnableWebMvc
public class WebMVCAdapter extends WebMvcConfigurerAdapter {
	
	@Bean
	public JasperReportsViewResolver getJasperReportsViewResolver() {
	  JasperReportsViewResolver resolver = new JasperReportsViewResolver();
	  resolver.setPrefix("classpath:/jasperreports/");
	  resolver.setSuffix(".jrxml");
	  resolver.setReportDataKey("datasource");
	  resolver.setViewNames("rpt_*");
	  resolver.setContentType("application/pdf");
	  resolver.setViewClass(JasperReportsMultiFormatView.class);
	  resolver.setOrder(0);
	  return resolver;
	} 
	   @Bean
	    public ViewResolver getViewResolver() {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("views");
	        resolver.setSuffix("");
	        resolver.setOrder(1);
	        return resolver;
	    }
	   @Override
	    public void configureDefaultServletHandling(
	            DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    } 
	   @Override
	   public void addViewControllers(ViewControllerRegistry registry) {
	     registry.addViewController("/").setViewName("forward:/index.html");
	   }

}
