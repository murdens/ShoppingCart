package com.murdens.cmsshoppingcart;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{


//provides beans to spring - commented out as home is no longer just s view.
    // @Override
    // public void addViewControllers(ViewControllerRegistry registry) {
    //     registry.addViewController("/").setViewName("home");
    // }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //required to live load images.  if move app to server need to change source location.
        registry
        .addResourceHandler("/media/**")
        .addResourceLocations("file:/C:/Users/User/Java_VSC/cmsshoppingcart/src/main/resources/static/media/");
    }
    
}