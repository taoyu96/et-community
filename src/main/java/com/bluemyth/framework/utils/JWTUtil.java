package com.bluemyth.framework.utils;

import io.jsonwebtoken.*;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * @author WTON
 */
@Configuration
public class JWTUtil {

    private static long NO_TIMEOUT = -1;

    private static String stringKey;

    /**
     * 注入私钥
     *
     * @param stringKey
     */
    @Value("${jwt.stringKey}")
    public void setStringKey(String stringKey) {
        JWTUtil.stringKey = stringKey;
    }

    /**
     * 由字符串生成加密key
     *
     * @return SecretKey
     */
    private static SecretKey generalKey() {
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 创建jwt
     *
     * @param id        uuid
     * @param subject   用户基本信息,json格式
     * @param ttlMillis 过期时间
     * @return jwt
     */
    public static String createJWT(String id, String subject, long ttlMillis) throws JwtException {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey key = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .signWith(signatureAlgorithm, key);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    /**
     * 创建jwt
     *
     * @param id      uuid
     * @param subject 用户基本信息,json格式
     * @return jwt  NO_TIMEOUT
     */
    public static String createJWT(String id, String subject) throws JwtException {
        return createJWT(id, subject, NO_TIMEOUT);
    }

    /**
     * 解密jwt
     *
     * @param jwt 需要解析的jwt
     * @return Claims 加密前的信息
     */
    public static Claims parseJWT(String jwt) throws JwtException {
        SecretKey key = generalKey();
        return Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();
    }

}
