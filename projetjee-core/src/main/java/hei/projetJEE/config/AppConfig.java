package hei.projetJEE.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by nicol on 10/02/2017.
 */
@Configuration
@ComponentScan(basePackages = "hei.projetJEE.service")
public class AppConfig
{
    @Bean
    public Properties dbProperties() throws  IOException{
        Properties properties = new Properties();
        properties.load(AppConfig.class.getClassLoader().getResourceAsStream("db.properties"));
        return properties;
    }
}