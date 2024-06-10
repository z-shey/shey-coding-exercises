package io.shey.demo03.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class JwtUtil {
    // 有效期
    private static final long JWT_TTL = 1000 * 60 * 60 * 24 * 7; // 7天

    // 设置盐值
    private static final String JWT_KEY = "SheyQ123aAAS";

    /**
     * 生成JWT
     *
     * @return 返回JWT字符串
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 生成JWT
     *
     * @param subject   主题,token中要存放的数据。可以是JSON数据，用户数据
     * @param ttlMillis 有效期
     * @return
     */
    public static String createJWT(String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, getUUID()); // 设置过期时间
        return builder.compact();
    }

    /**
     * 生成JWT
     *
     * @param subject   主题,token中要存放的数据。可以是JSON数据，用户数据
     * @param ttlMillis 有效期
     * @param uuid      唯一编号
     * @return
     */
    private static JwtBuilder getJwtBuilder(String subject, Long ttlMillis, String uuid) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        SecretKey secretKey = generalKey(); // 生成加密后的秘钥

        long nowMillis = System.currentTimeMillis(); // 获取系统当前时间

        Date now = new Date(nowMillis);

        if (ttlMillis == null) {
            ttlMillis = JwtUtil.JWT_TTL;
        }

        long expMillis = nowMillis + ttlMillis; // 过期时间

        Date expDate = new Date(expMillis); // 获取系统当前时间

        return Jwts.builder()
                .setId(uuid) // 设置唯一编号
                .setSubject(subject) // 设置主题
                .setIssuer("shey") // 设置签发者
                .setIssuedAt(now) // 设置签发时间
                .signWith(signatureAlgorithm, secretKey) // 设置签名使用的签名算法和签名使用的秘钥
                .setExpiration(expDate); // 设置过期时间
    }

    /**
     * 生成JWT
     *
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id, String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, null, id); // 设置过期时间
        return builder.compact();
    }


    /**
     * 生成加密后的秘钥 secretKey
     *
     * @return
     */
    private static SecretKey generalKey() {
        // 返回一个256位的随机字节
        byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }


    /**
     * 解析JWT
     *
     * @param jwt 传入的jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey(); // 签名秘钥，和生成的签名的秘钥一模一样
        return Jwts.parser()
                .setSigningKey(secretKey) // 设置签名的秘钥
                .parseClaimsJws(jwt) // 设置需要解析的jwt
                .getBody();
    }
}
