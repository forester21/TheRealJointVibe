package ru.jointvibe.mainwebservice.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.jointvibe.mainwebservice.jwt.TokenManager;

import static java.lang.String.valueOf;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class AccountController {

    @PostMapping("/api/userInfo")
    public String getUserId(@RequestBody String token, Authentication authentication) {
        return valueOf(TokenManager.decode(token).getClaims().get("userId").asInt());
    }
}
