package top.spencercjh.crabscore.judge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author spencercjh
 */
@SpringBootApplication
@EnableEurekaClient
public class CrabscoreJudgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrabscoreJudgeApplication.class, args);
    }

}

