package top.spencercjh.crabscore.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author spencercjh
 */
@SpringBootApplication
@EnableEurekaClient
public class CrabscoreAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrabscoreAdminApplication.class, args);
    }

}

