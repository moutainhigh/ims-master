package com.yianju.ims.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;
import java.util.Map;

@Data
@ConfigurationProperties("jwt.config")
public class JwtUtil {

    private String key;
    private long ttl;


    /**
     * 签发 token
     */
    public String createJWT(String id, String subject, Map<String,Object> map){
        long now=System.currentTimeMillis();
        long exp=now+ttl;
        JwtBuilder jwtBuilder = Jwts.builder().setId(id)
            .setSubject(subject).setIssuedAt(new Date())
            .signWith(SignatureAlgorithm.HS256, key);
        for(Map.Entry<String,Object> entry:map.entrySet()) {
            jwtBuilder.claim(entry.getKey(),entry.getValue());
        }
        if(ttl>0){
            jwtBuilder.setExpiration( new Date(exp));
        }
        String token = jwtBuilder.compact();
        return token;
    }

    /**
     * 解析token字符串获取clamis
     */
    public Claims parseJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims;
    }
}
