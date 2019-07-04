package ru.jointvibe.mainwebservice;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

public class JwtTest {

    @Test
    public void test() {
        Algorithm algorithmHS = Algorithm.HMAC256("secret");
        String token = JWT.create()
                .withIssuer("JV!")
                .withAudience("JV!")
                .withClaim("userId", 123)
                .sign(algorithmHS);
        System.out.println(token);

        JWTVerifier verifier = JWT.require(algorithmHS)
                .withIssuer("JV!")
                .build(); //Reusable verifier instance
        DecodedJWT jwt = verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJKViEiLCJ2a0tleSI6ImMwOGQxNzE3YzEzMzFmYjBlOWNhNDQzNzZhMmQyMWUxNDcxOGI3NWU1M2Y2MTU0ODg5OWQ2OTIwZDNiZjRjZjZiZTgxYzQ2ZmVlOTYwZGVlZmM1NTciLCJ1c2VySWQiOjU4NTU5MzE3fQ.enY1S_kSmrmToSMWXuTkyClaqpjWNHL2cyjqAxQYG2o");
        System.out.println(jwt);
    }
}
