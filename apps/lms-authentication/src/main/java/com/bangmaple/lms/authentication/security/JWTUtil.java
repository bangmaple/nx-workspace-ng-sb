package com.bangmaple.lms.authentication.security;

import com.bangmaple.lms.authentication.entites.UsersEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtil {
  private String secret = "1234567890092434239489234892439834289348948932894238942398423893489234893344232342342342342332423423423487654321";

  private String expirationTime = "36000000";
  private Key key;

  @PostConstruct
  public void init() {
    this.key = Keys.hmacShaKeyFor(secret.getBytes());
  }

  public Claims getAllClaimsFromToken(String token) {
    return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
  }

  public String getUsernameFromToken(String token) {
    return getAllClaimsFromToken(token).getSubject();
  }

  public Date getExpirationDateFromToken(String token) {
    return getAllClaimsFromToken(token).getExpiration();
  }

  private Boolean isTokenExpired(String token) {
    final Date expiration = getExpirationDateFromToken(token);
    return expiration.before(new Date());
  }

  public String generateToken(UsersEntity user) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("role", user.getRole());
    return doGenerateToken(claims, user.getUsername());
  }

  private String doGenerateToken(Map<String, Object> claims, String username) {
    Long expirationTimeLong = Long.parseLong(expirationTime); //in second
    final Date createdDate = new Date();
    final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong * 1000);

    return Jwts.builder()
      .setClaims(claims)
      .setSubject(username)
      .setIssuedAt(createdDate)
      .setExpiration(expirationDate)
      .signWith(key)
      .compact();
  }

  public Boolean validateToken(String token) {
    return !isTokenExpired(token);
  }
}
