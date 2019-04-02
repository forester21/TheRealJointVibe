package ru.jointvibe.mainwebservice.vk;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Users {

    private Map<Integer, VkUser> users = new HashMap<>();

    public void addUser(VkUser user){
        users.put(user.getUserId(), user);
    }
}
