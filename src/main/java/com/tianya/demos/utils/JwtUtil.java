package com.tianya.demos.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

/**
 * JWT令牌工具类：用于生成和解析用户身份令牌
 */
public class JwtUtil {

    private static final String KEY = "itheima";

    // 根据业务数据(Map)生成JWT令牌
    public static String genToken(Map<String, Object> claims) {
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))
                .sign(Algorithm.HMAC256(KEY));
    }

    // 解析JWT令牌，返回业务数据(Map)
    public static Map<String, Object> parseToken(String token) {
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }

    // 根据用户id生成JWT令牌
    public static String genToken(Long userId) {
        Map<String, Object> claims = Map.of("id", userId);
        return genToken(claims);
    }

    // 从JWT令牌中解析用户id
    public static Long getUserId(String token) {
        Map<String, Object> claims = parseToken(token);
        return Long.valueOf(claims.get("id").toString());
    }

}
