package hei.projetjee.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

/**
 * Created by Anaïck on 23/02/2017.
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "hei.projetjee.web.controller" })
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/css/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("/js/");
        registry.addResourceHandler("/bootstrap/**")
                .addResourceLocations("/bootstrap/");
    }

    @Bean
    public VelocityConfigurer velocityConfigurer(){
        VelocityConfigurer configurer = new VelocityConfigurer();
        configurer.setResourceLoaderPath("classpath:META-INF/resources");
        return configurer;
    }

    @Bean
    public VelocityViewResolver viewResolver(){
        VelocityViewResolver resolver = new VelocityViewResolver();
        resolver.setSuffix(".vm");
        return resolver;

    }
}
