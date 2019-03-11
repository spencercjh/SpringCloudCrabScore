package top.spencercjh.crabscor.eureka_server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author spencercjh
 */
@SpringBootApplication
@EnableEurekaServer
@RestController
public class CrabscoreEurekaServerApplication {
    private static Logger logger = LoggerFactory.getLogger(CrabscoreEurekaServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CrabscoreEurekaServerApplication.class, args);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<String> hello() {
        logger.info("called by product-service");
        return new ResponseEntity<>("hello product service!", HttpStatus.OK);
    }

}

