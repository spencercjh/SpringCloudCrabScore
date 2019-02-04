package top.spencercjh.crabscore.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author spencercjh
 */
@SpringBootApplication
@EnableEurekaClient
public class CrabscoreCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrabscoreCommonApplication.class, args);
    }

}

