package com.wsj.test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JwtTest {
    public static void main(String[] args) throws InterruptedException {

        //String token = createToken();

        //String s = parseToken(token);

        String tokenWithExp = createTokenWithExp();

        Thread.sleep(1000*61);

        String s = parseTokenWithTime(tokenWithExp);

        System.out.println(s);
    }

    public static String createToken(){
        JwtBuilder builder= Jwts.builder().setId("888")
                .setSubject("小白")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"itcast");
        System.out.println(builder.compact());
        return builder.compact();
    }

    public static String parseToken(String token){
        Claims claims = Jwts.parser().setSigningKey("itcast").parseClaimsJws(token).getBody();
        System.out.println("id:"+claims.getId());
        System.out.println("subject:"+claims.getSubject());
        System.out.println("IssuedAt:"+claims.getIssuedAt());

        return "";
    }


    public static String createTokenWithExp(){
        //为了方便测试，我们将过期时间设置为1分钟
        long now=System.currentTimeMillis();//当前时间
        long exp=now+1000*60;//过期时间为1分钟
        JwtBuilder builder=Jwts.builder().setId("888")
        .setSubject("小白")
        .setIssuedAt(new Date())
        .signWith(SignatureAlgorithm.HS256,"itcast")
        .setExpiration(new Date(exp))
        .claim("roles","admin") //自定义claims存储数据
        .claim("logo","logo.png");
        System.out.println(builder.compact());
        return builder.compact();
    }


    public static String parseTokenWithTime(String token){
        Claims claims=
        Jwts.parser().setSigningKey("itcast").parseClaimsJws(token).getBody();
        System.out.println("id:"+claims.getId());
        System.out.println("subject:"+claims.getSubject());
        System.out.println("roles:"+claims.get("roles"));
        System.out.println("logo:"+claims.get("logo"));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                System.out.println("签发时间:"+sdf.format(claims.getIssuedAt()));
        System.out.println("过期时间:"+sdf.format(claims.getExpiration()));
        System.out.println("当前时间:"+sdf.format(new Date()));

        return "";
    }
}
