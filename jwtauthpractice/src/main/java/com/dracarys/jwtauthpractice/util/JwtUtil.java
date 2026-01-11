package com.dracarys.jwtauthpractice.util;


import com.dracarys.jwtauthpractice.token.JwtAuthenticationToken;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

      private final String SECRET_KEY = "hello-how-are-you-i-am-fine-what-about-you";
      private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

      public String generateToken(String username, long minutes) {
          return Jwts.builder()
                  .setSubject(username)
                  .setIssuedAt(new Date())
                  .setExpiration(new Date(System.currentTimeMillis() + minutes * 60 * 1000))
                  .signWith(key)
                  .compact();
      }

    public String validateTokenAndExtractUserName(String token) {
          try {
              System.out.println("Token is : " + token);
              return Jwts.parserBuilder()
                      .setSigningKey(key)
                      .build()
                      .parseClaimsJws(token)
                      .getBody()
                      .getSubject();
          }
          catch (Exception e) {
              e.printStackTrace();
              return null;
          }
    }
}
