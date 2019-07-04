package ru.jointvibe.mainwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jointvibe.mainwebservice.pojo.UserId;
import ru.jointvibe.mainwebservice.vk.client.VkApiClient;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class AccountController extends AbstractController {

    @Autowired
    private VkApiClient client;

    //TODO REFACTOR USER_ID CLASS
    @GetMapping("/api/account/userId")
    public UserId userId() {
        return UserId.builder().id(getUserId()).build();
    }

    @GetMapping("/api/account/userInfo")
    public String getUserInfo() {
        return client.getUserInfo(getVkKey(), getUserId());
    }
}
