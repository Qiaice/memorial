package org.tsubakice.util;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "token")
public class JwtBuilder {

    private String secret;
    private String issuer;
    private String subject;
    private Long issuedAt;
    private Long expiration;

    public String createToken(Map<String, Object> payload) {
        return createToken(Map.of("typ", "JWT"), payload);
    }

    public String createToken(Map<String, Object> header, Map<String, Object> payload) {
        return Jwts.builder()
                .header()
                .add(header)
                .and()
                .claims(payload)
                .issuer(issuer)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis() + issuedAt))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()), Jwts.SIG.HS256)
                .compact();
    }

    public Jws<Claims> parseToken(String token) {
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .build()
                .parseSignedClaims(token);
    }

    public JwsHeader parseTokenToGetHeader(String token) {
        return parseToken(token).getHeader();
    }

    public Claims parseTokenToGetPayload(String token) {
        return parseToken(token).getPayload();
    }
}
