package top.spencercjh.crabscor.eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author spencercjh
 */
@SpringBootApplication
@EnableEurekaServer
public class CrabscoreEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrabscoreEurekaServerApplication.class, args);
    }
}

