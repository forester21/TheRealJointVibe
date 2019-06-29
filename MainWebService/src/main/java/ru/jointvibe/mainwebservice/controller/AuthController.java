package ru.jointvibe.mainwebservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.jointvibe.mainwebservice.jwt.TokenManager;
import ru.jointvibe.mainwebservice.vk.AuthClient;
import ru.jointvibe.mainwebservice.vk.VkUser;
import ru.jointvibe.mainwebservice.vk.request.VkApi;

import javax.servlet.http.HttpServletResponse;

import static java.lang.String.format;
import static ru.jointvibe.mainwebservice.Constants.AUTH;
import static ru.jointvibe.mainwebservice.Constants.FRONT_URI;

@Slf4j
@Controller
//TODO configure CORS
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class AuthController {

    public static final String USER_PAGE_TEMPLATE = FRONT_URI + AUTH + "?token=%s";

    @Autowired
    private AuthClient client;

    /**
     * Returns link for VK login page
     */
    @ResponseBody
    @GetMapping("/auth")
    public String auth() {
        return VkApi.auth();
    }

    /**
     * Takes VK temporary token, receives final token from VK, generates JV token
     * and redirects user to home page with it in URL parameter
     */
    @GetMapping("/token")
    public ModelAndView tokenResponse(@RequestParam String code) {
        VkUser user = client.getToken(code);
        return new ModelAndView("redirect:" + getPageWithUserInfo(TokenManager.generate(user.getToken(), user.getUserId())));
    }

    /**
     * URL for user home page with token in URL parameter
     */
    private String getPageWithUserInfo(String token){
        return format(USER_PAGE_TEMPLATE, token);
    }
}
