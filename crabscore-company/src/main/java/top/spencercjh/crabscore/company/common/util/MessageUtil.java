package top.spencercjh.crabscore.company.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 发送验证码
 * 接口示例：https://dev.yunxin.163.com/docs/product/%E7%9F%AD%E4%BF%A1/%E7%9F%AD%E4%BF%A1%E6%8E%A5%E5%85%A5%E7%A4%BA%E4%BE%8B
 * 接口概述：https://dev.yunxin.163.com/docs/product/IM%E5%8D%B3%E6%97%B6%E9%80%9A%E8%AE%AF/%E6%9C%8D%E5%8A%A1%E7%AB%AFAPI%E6%96%87%E6%A1%A3/%E6%8E%A5%E5%8F%A3%E6%A6%82%E8%BF%B0
 *
 * @author netease liuxuanlin
 */
@Log4j2
@Component
public class MessageUtil {
    @Value("${netease.verifySeverUrl}")
    private String verifySeverUrl;
    @Value("${netease.sendSeverUrl}")
    private String sendServerUrl;
    @Value("${netease.appkey}")
    private String appKey;
    @Value("${netease.appsecret}")
    private String appSecret;
    /**
     * 128位以内的随机数
     */
    private String nonce = String.valueOf(new Random().nextInt(128));
    @Value("${netease.templatId}")
    private String templateId;
    @Value("${netease.codeLength}")
    private String codeLength;

    @SuppressWarnings("SpellCheckingInspection")
    public boolean sendCode(String mobile) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(sendServerUrl);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        List<NameValuePair> nameValuePairs = new ArrayList<>(3);
        nameValuePairs.add(new BasicNameValuePair("templateid", templateId));
        nameValuePairs.add(new BasicNameValuePair("mobile", mobile));
        nameValuePairs.add(new BasicNameValuePair("codeLen", codeLength));
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));
        HttpResponse response = httpClient.execute(httpPost);
        JSONObject result = JSON.parseObject(EntityUtils.toString(response.getEntity(), "utf-8"));
        Integer code = result.getInteger("code");
        return (code == 200);
    }

    public boolean verifyCode(String mobile, String code) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(verifySeverUrl);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        List<NameValuePair> nameValuePairs = new ArrayList<>(3);
        nameValuePairs.add(new BasicNameValuePair("code", code));
        nameValuePairs.add(new BasicNameValuePair("mobile", mobile));
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));
        HttpResponse response = httpClient.execute(httpPost);
        JSONObject result = JSON.parseObject(EntityUtils.toString(response.getEntity(), "utf-8"));
        Integer codeResult = result.getInteger("code");
        return (codeResult == 200);
    }
}