package top.spencercjh.crabscore.judge.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.codec.binary.Base64;
import top.spencercjh.crabscore.judge.common.CommonConstant;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * reference:https://blog.csdn.net/qq_37636695/article/details/79265711
 *
 * @author spencercjh
 */
@Log4j2
public class JwtUtil {
    /**
     * 创建jwt
     *
     * @param id      JWT唯一标识ID
     * @param subject 含有业务逻辑的JSON
     * @return JWT串
     */
    public static String createJWT(String id, String subject) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        /*创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）*/
        Map<String, Object> claims = new HashMap<>(3);
        claims.put(CommonConstant.MYKEY, CommonConstant.MYKEY_VALUE);
        /*生成签名的时候使用的秘钥secret,这个方法本地封装了的，一般可以从本地配置文件中读取，切记这个秘钥不能外露哦。
        它就是你服务端的私钥，在任何场景都不应该流露出去。一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。*/
        SecretKey key = generalKey();
        /*这里其实就是new一个JwtBuilder，设置jwt的body*/
        JwtBuilder builder = Jwts.builder()
                /*如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，
                一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的*/
                .setClaims(claims)
                /*设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。*/
                .setId(id)
                /*jwt的签发时间*/
                .setIssuedAt(now)
                /*代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。*/
                .setSubject(subject)
                /*设置签名使用的签名算法和签名使用的秘钥*/
                .signWith(signatureAlgorithm, key);
        if (CommonConstant.TTLMILLIS >= 0) {
            long expMillis = nowMillis + CommonConstant.TTLMILLIS;
            Date exp = new Date(expMillis);
            /*设置过期时间*/
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    /**
     * 解密jwt
     *
     * @param jwt JWT串
     * @return claims
     */
    public static Claims parseJWT(String jwt) {
        SecretKey key = generalKey();
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt).getBody();
    }

    /**
     * 由字符串生成加密key
     * jasypt.encryptor.password
     *
     * @return 加密key
     */
    private static SecretKey generalKey() {
        String stringKey = "spencercjh";
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    public static void main(String[] args) {
        String ab = createJWT("jwt", "{\"username\":\"admin\",\"roleId\":1}");
        System.out.println(ab);
        Claims c = parseJWT(ab);
        System.out.println("id" + c.getId());
        System.out.println("issued" + c.getIssuedAt());
        System.out.println("subject" + c.getSubject());
        System.out.println("issuer" + c.getIssuer());
        System.out.println(CommonConstant.MYKEY + c.get(CommonConstant.MYKEY, String.class));
    }

}
