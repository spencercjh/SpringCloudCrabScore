package top.spencercjh.crabscore.staff.common.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;
import lombok.extern.log4j.Log4j2;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Exrickx
 */
@Log4j2
@Component
public class QiniuUtil {

    /**
     * 生成上传凭证，然后准备上传
     */
    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.bucket}")
    private String bucket;

    @Value("${qiniu.domain}")
    private String domain;

    /**
     * 构造一个带指定Zone对象的配置类 zone0华东 zone1华北 zone2华南
     */
    private static Configuration cfg = new Configuration(Zone.zone0());

    private static UploadManager uploadManager = new UploadManager(cfg);

    /**
     * 文件路径上传
     *
     * @param filePath 文件路径
     * @param key      文件名
     * @return response
     */
    public String qiniuUpload(String filePath, String key) {

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(filePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return domain + putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            log.warn(r.toString());
            try {
                log.warn(r.bodyString());
                return r.bodyString();
            } catch (QiniuException ex2) {
                //ignore
            }
            return r.toString();
        }
    }

    /**
     * 文件流上传
     *
     * @param file 文件流
     * @param key  文件名
     * @return response
     */
    public String qiniuInputStreamUpload(FileInputStream file, String key) {

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(file, key, upToken, null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return domain + putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            try {
                log.warn(r.bodyString());
                return r.bodyString();
            } catch (QiniuException ex2) {
                //ignore
            }
            return r.toString();
        }
    }

    /**
     * Base64上传
     *
     * @param data64 base64
     * @return respone
     */
    public String qiniuBase64Upload(String data64) {

        String key = renamePic("");
        //服务端http://up-z2.qiniup.com
        String url = "http://up-z2.qiniup.com/putb64/-1/key/" + UrlSafeBase64.encodeToString(key);
        RequestBody rb = RequestBody.create(null, data64);
        Request request = new Request.Builder().
                url(url).
                addHeader("Content-Type", "application/octet-stream")
                .addHeader("Authorization", "UpToken " + getUpToken())
                .post(rb).build();
        OkHttpClient client = new OkHttpClient();
        okhttp3.Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return domain + key;
    }

    private String getUpToken() {
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(bucket, null, 3600, new StringMap().put("insertOnly", 1));
    }

    public String base64Data(String data) {

        if (data == null || data.isEmpty()) {
            return "";
        }
        String base64 = data.substring(data.lastIndexOf(",") + 1);
        return base64;
    }

    /**
     * 以UUID重命名
     *
     * @param fileName 文件名
     * @return uuid
     */
    public String renamePic(String fileName) {
        String extName = fileName.substring(fileName.lastIndexOf("."));
        return UUID.randomUUID().toString().replace("-", "") + extName;
    }
}