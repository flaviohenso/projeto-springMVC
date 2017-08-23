/**
 * projeto-springMVC : 22 de ago de 2017
 */
package com.projetoSpringMVC.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

/**
 * @author flavio
 *
 */
@Configuration
public class ThymeleafWebMvcConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
 
    private ApplicationContext applicationContext;

	@Bean
	public ViewResolver viewResolver(){
		ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
		thymeleafViewResolver.setTemplateEngine(templateEngine());
		
		return thymeleafViewResolver; 
	}

	/**
	 * @return
	 */
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
		springTemplateEngine.setTemplateResolver(templateResolver());
		springTemplateEngine.addDialect(new LayoutDialect());
		return springTemplateEngine;
	}

	/**
	 * @return
	 */
	private ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver resourceTemplateResolver = new SpringResourceTemplateResolver();
		resourceTemplateResolver.setTemplateMode(TemplateMode.HTML);
		resourceTemplateResolver.setApplicationContext(applicationContext);
		resourceTemplateResolver.setCharacterEncoding("UTF-8");
		resourceTemplateResolver.setCacheable(false);
		resourceTemplateResolver.setPrefix("classpath:/templates/");
		resourceTemplateResolver.setSuffix(".html");
		
		return resourceTemplateResolver;
	}

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		this.applicationContext = appContext;
	}
	
}
