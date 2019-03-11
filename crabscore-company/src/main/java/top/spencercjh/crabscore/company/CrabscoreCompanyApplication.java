package top.spencercjh.crabscore.company;

import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.spencercjh.crabscore.company.common.util.ResultUtil;
import top.spencercjh.crabscore.company.common.vo.Result;

/**
 * @author spencercjh
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"top.spencercjh.crabscore.company.dao"}, annotationClass = Repository.class)
@RestController
@Log4j2
public class CrabscoreCompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrabscoreCompanyApplication.class, args);
    }

    @GetMapping(value = "/hello", produces = {"application/json;charset=UTF-8"})
    public Result helloWorld() {
        log.debug("Company Service HelloWorld");
        return new ResultUtil<>().setSuccessMsg("HelloWorld");
    }
}

