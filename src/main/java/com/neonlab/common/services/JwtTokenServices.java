package com.neonlab.common.services;

import com.neonlab.common.annotations.Loggable;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@Loggable
public class JwtTokenServices {

    public static final String SECRET = "yourSecretyourSecretyourSecretyourSecretyourSecretyourSecretyourSecret";

    public String generateToken(String userName){
        Map<String,Object> claims=new HashMap<>();
        return createToken(claims,userName);
    }

    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
                .signWith(getSignKey(), SignatureAlgorithm.ES256).compact();
    }

    private Key getSignKey() {
        byte[] keyBytes= SECRET.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
