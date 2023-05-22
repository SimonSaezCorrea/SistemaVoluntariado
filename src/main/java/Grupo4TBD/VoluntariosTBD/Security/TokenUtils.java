package Grupo4TBD.VoluntariosTBD.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenUtils {
  private static final String JWT_SECRET_KEY = "4qhq8LrEBfYcaRHxhdb9zURb2rf8e7Ud";
  public static final long JWT_TOKEN_VALIDITY = 2_592_00L;

  public static String createToken(String nombre, String email) {
    long expirationTime = JWT_TOKEN_VALIDITY + 1000;
    Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

    Map<String, Object> extra = new HashMap<String, Object>();
    extra.put("nombre", nombre);

    return Jwts.builder()
            .setSubject(email)
            .setExpiration(expirationDate)
            .addClaims(extra)
            .signWith(Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes()))
            .compact();
  }

  public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
    try {
      Claims claims = Jwts.parserBuilder()  //parserBuilder
              .setSigningKey(JWT_SECRET_KEY.getBytes())
              .build()
              .parseClaimsJws(token)
              .getBody();

      String email = claims.getSubject();

      return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
    } catch (JwtException e) {
      return null;
    }
  }
}
