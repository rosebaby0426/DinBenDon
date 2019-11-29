package com.christine.dinbendon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
/**
 * Christine 2019/11/28
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.christine.dinbendon.*"})//mybatis掃描路徑
public class DinBenDonApplication {

    @Value("${server.tomcat.protocol:org.apache.coyote.http11.Http11Nio2Protocol}")
    private String tomcatProtocol;

    public static void main(String[] args) {
        SpringApplication.run(DinBenDonApplication.class, args);
    }

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.setProtocol(tomcatProtocol);
        return tomcat;
    }
}
