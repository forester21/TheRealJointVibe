package ru.jointvibe.mainwebservice.controller;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Map;

import static ru.jointvibe.mainwebservice.jwt.TokenManager.USER_ID;
import static ru.jointvibe.mainwebservice.jwt.TokenManager.VK_KEY;

public class AbstractController {

    protected int getUserId() {
        return getClaims().get(USER_ID).asInt();
    }

    protected String getVkKey() {
        return getClaims().get(VK_KEY).asString();
    }

    /**
     * Метод для получения данных из JWT
     */
    private Map<String, Claim> getClaims() {
        return ((DecodedJWT) SecurityContextHolder.getContext()
                .getAuthentication().getDetails()).getClaims();
    }
}
