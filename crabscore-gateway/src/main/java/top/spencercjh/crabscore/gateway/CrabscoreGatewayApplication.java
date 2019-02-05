package top.spencercjh.crabscore.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author spencercjh
 */
@SpringBootApplication
@EnableZuulProxy
@RestController
public class CrabscoreGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrabscoreGatewayApplication.class, args);
    }

    @GetMapping("/")
    public String test() {
        return "Hello World Zuul";
    }
}

