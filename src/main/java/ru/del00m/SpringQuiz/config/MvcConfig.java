package ru.del00m.SpringQuiz.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Value("${img.upload.dir}")
    private String imgUploadDir;

    @Value("${static_dir.path}")
    private String staticDirPath;

    @Value("${img.path}")
    private String imgPath;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/quiz").setViewName("quiz");
        registry.addViewController("/").setViewName("quiz");
        registry.addViewController("/addquiz").setViewName("addquiz");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(imgUploadDir + "/**").addResourceLocations(
                "file:///" + System.getProperty("user.dir") + staticDirPath + imgPath + imgUploadDir + File.separator);
    }
}