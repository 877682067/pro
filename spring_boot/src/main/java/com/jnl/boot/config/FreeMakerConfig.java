package com.jnl.boot.config;

import freemarker.template.TemplateException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;

@Configuration
public class FreeMakerConfig {

  /*  @Bean
    public InternalResourceViewResolver getJspViewResolver(){
        InternalResourceViewResolver jspViewResolver=new InternalResourceViewResolver();
        jspViewResolver.setPrefix("/WEB-INF/");
        jspViewResolver.setSuffix(".jsp");
        jspViewResolver.setViewClass(JstlView.class);
        jspViewResolver.setViewNames("jsp/*");
        jspViewResolver.setOrder(10);
        jspViewResolver.setCache(false);
        return jspViewResolver;
    }*/

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() throws IOException, TemplateException {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("classpath:/view");
        return configurer;
    }

    @Bean
    @ConditionalOnProperty(name = "spring.freemarker.enabled", matchIfMissing = true)
    public FreeMarkerViewResolver viewResolver() {
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setCache(false);
        freeMarkerViewResolver.setSuffix(".ftl");
        freeMarkerViewResolver.setContentType("text/html; charset=UTF-8");
        freeMarkerViewResolver.setOrder(1);
        freeMarkerViewResolver.setViewNames("/*");
        freeMarkerViewResolver.setViewClass(FreeMarkerView.class);
        return freeMarkerViewResolver;
    }
}
