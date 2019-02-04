package top.spencercjh.crabscore.judge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author spencercjh
 */
@SpringBootApplication
@MapperScan(basePackages = {"top.spencercjh.crabscore.judge.dao"}, annotationClass = Repository.class)
@EnableEurekaClient
@RestController
public class CrabscoreJudgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrabscoreJudgeApplication.class, args);
    }

    @GetMapping("/")
    public String test() {
        return "Hello World";
    }
}

