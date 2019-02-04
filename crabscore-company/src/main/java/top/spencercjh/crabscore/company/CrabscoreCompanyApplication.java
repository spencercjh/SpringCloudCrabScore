package top.spencercjh.crabscore.company;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.stereotype.Repository;

/**
 * @author spencercjh
 */
@SpringBootApplication
@EnableEurekaServer
@MapperScan(basePackages = {"top.spencercjh.crabscore.company.dao"}, annotationClass = Repository.class)
public class CrabscoreCompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrabscoreCompanyApplication.class, args);
    }
}

