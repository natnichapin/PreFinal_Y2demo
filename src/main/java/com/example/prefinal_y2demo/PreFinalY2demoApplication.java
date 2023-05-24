package com.example.prefinal_y2demo;

import com.example.prefinal_y2demo.properties.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class,

})
public class PreFinalY2demoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PreFinalY2demoApplication.class, args);
    }

}
