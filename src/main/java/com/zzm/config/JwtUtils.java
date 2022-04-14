package com.zzm.config;


import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTHeader;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : lzy
 * @CreateTime : 2021/6/18
 * @Description :
 **/
public class JwtUtils {


    public static String getJWTString(String userName) {
        // 密钥
        byte[] key = "1234567890".getBytes();
        String token = JWT.create()
                .setPayload("phone", userName)
                .setPayload("name", "looly")
                .setPayload("admin", true)
                .setKey(key)
                .sign();
        return token;
    }

    public static Map getInfo(String token) {
        // 密钥
        JWT jwt = JWT.of(token);

        // JWT
         jwt.getHeader(JWTHeader.TYPE);
        // HS256
         jwt.getHeader(JWTHeader.ALGORITHM);
        Map map = new HashMap();
        // 1234567890
        map.put("sub",jwt.getPayload("phone"));
        map.put("name",jwt.getPayload("name"));
        map.put("admin",jwt.getPayload("admin"));

        return map;
    }






}