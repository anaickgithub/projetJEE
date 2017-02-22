package hei.projetjee.web;

import hei.projetJEE.config.AppConfig;
import hei.projetJEE.config.DBConfig;
import hei.projetjee.web.config.WSConfig;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * Created by Anaïck on 22/02/2017.
 */
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /*@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        Dynamic servlet = servletContext.addServlet("cxfServlet", new CXFServlet());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");
    }*/

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { AppConfig.class, DBConfig.class, WSConfig.class };
    }


    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {};
    }


    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
