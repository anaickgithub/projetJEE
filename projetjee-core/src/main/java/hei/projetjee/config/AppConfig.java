package hei.projetjee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by nicol on 10/02/2017.
 */
@Configuration
@ComponentScan(basePackages = "hei.projetjee.service")
public class AppConfig
{
    @Bean
    public Properties dbProperties() throws  IOException{
        Properties properties = new Properties();
        properties.load(AppConfig.class.getClassLoader().getResourceAsStream("db.properties"));
        return properties;
    }
}