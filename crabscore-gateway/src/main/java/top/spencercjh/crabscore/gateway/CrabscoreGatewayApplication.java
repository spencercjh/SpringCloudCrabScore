package top.spencercjh.crabscore.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author spencercjh
 */
@SpringBootApplication
@EnableZuulProxy
public class CrabscoreGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrabscoreGatewayApplication.class, args);
    }

}

