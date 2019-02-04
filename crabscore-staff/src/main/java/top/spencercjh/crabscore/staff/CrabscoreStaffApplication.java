package top.spencercjh.crabscore.staff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author spencercjh
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class CrabscoreStaffApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrabscoreStaffApplication.class, args);
    }

    @GetMapping("/")
    public String test() {
        return "hello world";
    }
}

