package ru.jointvibe.mainwebservice.vk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.jointvibe.mainwebservice.vk.request.VkApi;

import static java.lang.String.format;
import static ru.jointvibe.mainwebservice.Constants.ACCOUNT;
import static ru.jointvibe.mainwebservice.Constants.FRONT_URI;

@Slf4j
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Auth {

    public static final String USER_PAGE_TEMPLATE = FRONT_URI + ACCOUNT + "?user_id=%s";

    @Autowired
    private AuthClient client;

    @GetMapping("/auth")
    public ModelAndView auth() {
        return new ModelAndView("redirect:" + VkApi.auth());
    }

    @GetMapping("/token")
    public ModelAndView tokenResponse(@RequestParam String code) {
        VkUser user = client.getToken(code);
        return new ModelAndView("redirect:" + getPageWithUserInfo(user));
    }

    private String getPageWithUserInfo(VkUser user){
        return format(USER_PAGE_TEMPLATE, user.getUserId());
    }
}
