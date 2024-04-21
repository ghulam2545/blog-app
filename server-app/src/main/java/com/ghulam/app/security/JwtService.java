package com.ghulam.app.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    @Value("${app.jwt.secret-key}")
    private String PRIVATE_SECRET_KEY;

    public String getUsername(String token) {
        Claims payload = Jwts
                .parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        /* todo */
        return payload.getSubject().replaceAll("\\s", "");
    }

    public boolean validate(String token) {
        Claims payload = Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        Date expiration = payload.getExpiration();
        return expiration.after(new Date());
    }

    /**
     * This generated token can be verified from
     * <a href="https://jwt.io/">https://jwt.io/</a>
     * by providing our PRIVATE_SECRET_KEY
     */
    public String generateToken(Authentication authenticated) {
        UserDetails principal = (UserDetails) authenticated.getPrincipal();
        String username = principal.getUsername();

        Date now = new Date();
        Date expiry = new Date(now.getTime() + 1000 * 60 * 60 * 10); // 10 hours

        return Jwts
                .builder()
                .subject(username)
                .issuedAt(now)
                .expiration(expiry)
                .signWith(getSigningKey())
                .compact();
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(PRIVATE_SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
