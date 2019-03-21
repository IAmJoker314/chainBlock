package com.wxiip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:HuangHua
 * @Descirption:
 * @Date: Created by huanghua on 2018/10/20.
 * @Modified By:
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run( Application.class, args );
    }
}