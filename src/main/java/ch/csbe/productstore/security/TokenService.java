package ch.csbe.productstore.security;

import ch.csbe.productstore.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Service
public class TokenService {

    private final SecretKey secretKey = Keys.hmacShaKeyFor(
            Base64.getDecoder().decode("a2VlcGl0c2FmZTEyMzQ1Njc4OTAxMjM0NTY3ODkwMTIzNA==")
    );

    public String generateToken(User user) {
        // Debug-Ausgabe (optional)
        System.out.println("🪪 JWT GENERIEREN FÜR:");
        System.out.println("  ✉️ Email: " + user.getEmail());
        System.out.println("  🎭 Rollen: " + user.getRoles());

        // Sicherheits-Check: null-Werte vermeiden
        if (user.getEmail() == null || user.getRoles() == null) {
            throw new IllegalArgumentException("User email or roles is null – JWT kann nicht generiert werden.");
        }

        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("roles", user.getRoles())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10h
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }


    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
