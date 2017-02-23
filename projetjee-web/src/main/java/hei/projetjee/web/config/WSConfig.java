package hei.projetjee.web.config;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import hei.projetjee.web.controller.RestController;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anaïck on 22/02/2017.
 */
@Configuration
@ComponentScan(basePackages = "hei.projetjee.web.controller")
@ImportResource({"classpath:META-INF/cxf/cxf.xml"})
public class WSConfig {

    @Inject
    private Bus cxfBus;

    @Inject
    private List<RestController> controllers;

    @Bean
    public Server jaxrsServer(JacksonJsonProvider jsonProvider){
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        List<Object> serviceBeans = new ArrayList<Object>();
        serviceBeans.addAll(controllers);
        sf.setServiceBeans(serviceBeans);
        sf.setProviders(Arrays.asList(jsonProvider));
        sf.setAddress("/");
        sf.setBus(cxfBus);
        return sf.create();
    }

    @Bean
    public JacksonJsonProvider jsonProvider() {
        return new JacksonJsonProvider();
    }
}
