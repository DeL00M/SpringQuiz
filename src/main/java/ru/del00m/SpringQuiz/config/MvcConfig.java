package ru.del00m.SpringQuiz.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Value("${img.upload.dir}")
    private String imgUploadDir;

    @Value("${static_dir.path}")
    private String staticDirPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = "file:" + File.separator + File.separator + File.separator + new File("").getAbsolutePath() + Paths.get(staticDirPath + imgUploadDir) + File.separator;
        registry.addResourceHandler("/img/**").addResourceLocations(path);
    }
}
