package ru.jointvibe.mainwebservice.controller;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class TestController {

    @GetMapping("/test/api/public")
    public String publicEndpoint() {
        return "public!";
    }

    @GetMapping("/test/api/private")
    public String privateEndpoint(Authentication auth, Principal principal) {
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "private!";
    }

    @GetMapping("/test/api/private-scoped")
    public String privateScopedEndpoint() {
        return "private-scoped!";
    }
}
