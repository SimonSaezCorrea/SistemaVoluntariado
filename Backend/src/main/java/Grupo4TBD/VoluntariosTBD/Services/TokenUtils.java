package Grupo4TBD.VoluntariosTBD.Services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TokenUtils {
  private static final String JWT_SECRET_KEY = "4qhq8LrEBfYcaRHxhdb9zURb2rf8e7Ud";
  public static final long JWT_TOKEN_VALIDITY = 2_592_00L;

  public String extractEmail(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    return claimsResolver.apply(extractAllClaims(token));
  }

  private Claims extractAllClaims(String token) {
    return Jwts.parserBuilder()  //parserBuilder
            .setSigningKey(JWT_SECRET_KEY.getBytes())
            .build()
            .parseClaimsJws(token)
            .getBody();
  }

  public static String createToken(UserDetailsImp userDetails) {
    Map<String, Object> extra = new HashMap<String, Object>();
    extra.put("nombre", userDetails.getNombre());

    String authorities = userDetails.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(","));

    return Jwts.builder()
            .setSubject(userDetails.getUsername())
            .addClaims(extra)
            .claim("roles", authorities)
            .signWith(Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
            .compact();
  }

  public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
    try {
      Claims claims = Jwts.parserBuilder()
              .setSigningKey(JWT_SECRET_KEY.getBytes())
              .build()
              .parseClaimsJws(token)
              .getBody();

      String email = claims.getSubject();

      Collection<SimpleGrantedAuthority> authorities =
              Arrays.stream(claims.get("roles").toString().split(","))
                      .map(SimpleGrantedAuthority::new)
                      .collect(Collectors.toList());
      return new UsernamePasswordAuthenticationToken(email, "", authorities);
    } catch (JwtException e) {
      return null;
    }
  }

}
