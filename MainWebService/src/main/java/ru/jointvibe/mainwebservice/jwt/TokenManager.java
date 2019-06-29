package ru.jointvibe.mainwebservice.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import static ru.jointvibe.mainwebservice.security.SecurityConfig.API_AUDIENCE;
import static ru.jointvibe.mainwebservice.security.SecurityConfig.ISSUER;
import static ru.jointvibe.mainwebservice.security.SecurityConfig.SECRET;

/**
 * Manager for encoding/decoding JWT
 */
public class TokenManager {

    private static final Algorithm algorithmHS = Algorithm.HMAC256(SECRET);
    private static final JWTVerifier verifier;

    static {
        verifier = JWT.require(algorithmHS)
                .withIssuer(ISSUER)
                .withAudience(API_AUDIENCE)
                .build();
    }

    public static String generate(String vkKey, int userId) {
        return JWT.create()
                .withIssuer(ISSUER)
                .withAudience(API_AUDIENCE)
                .withClaim("vkKey", vkKey)
                .withClaim("userId", userId)
                .sign(algorithmHS);
    }

    public static DecodedJWT decode(String token) {
        return verifier.verify(token);
    }
}
