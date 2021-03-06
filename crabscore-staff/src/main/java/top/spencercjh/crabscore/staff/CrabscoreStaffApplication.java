package top.spencercjh.crabscore.staff;

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
@EnableEurekaClient
@MapperScan(basePackages = {"top.spencercjh.crabscore.staff.dao"}, annotationClass = Repository.class)
@RestController
public class CrabscoreStaffApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrabscoreStaffApplication.class, args);
    }

    @GetMapping(value = "/hello", produces = {"application/json;charset=UTF-8"})
    public String test() {
        return "hello world STAFF";
    }
}

