package com.itheima;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGen(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","张三");
        //生成Jwt
        String token = JWT.create()
                    .withClaim("user", claims)  // Payload
                    .withExpiresAt(new Date(System.currentTimeMillis()*1000*60*60*12))  // 过期时间
                    .sign(Algorithm.HMAC256("itheima"));
        System.out.println(token);
    }

    @Test
    public void testParse(){
        //定义字符串，模拟用户
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9" +
                ".eyJ1c2VyTmFtZSI6ImJhb2JhbyIsImV4cCI6LTEzNzA5NzQ0NTIyNTQwNiwidXNlcklkIjoyMX0" +
                ".yCU3L4oyq0S8qCOHY4Svx3MPxE9z-488K8uExZ2gW7c";
        JWTVerifier jwtVerifier = jwtVerifier = JWT.require(Algorithm.HMAC256("itheima")).build();

//        DecodedJWT decodedJWT = jwtVerifier.verify(token);//验证token，生成一个解析后的JWT对象
//        Map<String,Claim> claims = decodedJWT.getClaims();
//        System.out.println(claims.get("user"));

    }
}
