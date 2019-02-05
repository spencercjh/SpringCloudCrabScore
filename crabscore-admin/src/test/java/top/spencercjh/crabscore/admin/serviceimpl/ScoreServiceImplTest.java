package top.spencercjh.crabscore.admin.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.spencercjh.crabscore.admin.entity.Competition;

/**
 * @author : spencercjh
 * @date : 2019/2/6 3:44
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScoreServiceImplTest {

    @Autowired
    ScoreServiceImpl scoreService;

    @Test
    public void calculateFatnessScore() {
        Competition presentCompetition = JSONObject.parseObject("{\"competitionId\":1,\"competitionYear\":\"2017\",\"varFatnessM\":0.9,\"varFatnessF\":1,\"varWeightM\":0.09,\"varWeightF\":0.1,\"varMfatnessSd\":0.1,\"varMweightSd\":0.09,\"varFfatnessSd\":0.1,\"varFweightSd\":0.1,\"resultFatness\":1,\"resultQuality\":1,\"resultTaste\":1,\"note\":null,\"status\":1,\"createDate\":\"2017-01-01 02:00:00\",\"createUser\":\"manual\",\"updateDate\":\"2017-01-01 02:00:00\",\"updateUser\":\"manual\",\"avatarUrl\":\"http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg\"}",
                Competition.class);
        scoreService.calculateFatnessScore(1, 1, 1, presentCompetition, "admin");
    }

    @Test
    public void calculateQualityScore() {
        scoreService.calculateQualityScore(1, 1, 0, "admin");
    }

    @Test
    public void calculateTasteScore() {
        scoreService.calculateTasteScore(1, 1, 0, "admin");
    }
}