package top.spencercjh.crabscore.company;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.spencercjh.crabscore.company.common.util.JasyptUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class CrabscoreCompanyApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void testJasypt() {
        String password = "spencercjh";
        System.out.println("url:\t" + JasyptUtil.encryptPwd(password, "jdbc:mysql://193.112.35.66:3306"));
        System.out.println("root:\t" + JasyptUtil.encryptPwd(password, "root"));
        System.out.println("key:\t" + JasyptUtil.encryptPwd(password, "407031"));

    }
}

