package top.spencercjh.crabscore.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author spencercjh
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class CrabscoreAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrabscoreAdminApplication.class, args);
    }

    @GetMapping("/")
    public String test() {
        return "hello world";
    }
}

