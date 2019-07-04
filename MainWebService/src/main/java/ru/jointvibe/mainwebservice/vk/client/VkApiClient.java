package ru.jointvibe.mainwebservice.vk.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.jointvibe.mainwebservice.vk.request.VkApi;

@Component
public class VkApiClient {

    @Autowired
    private RestTemplate restTemplate;

    public String getUserInfo(String accessToken, int userId){
        return restTemplate.getForObject(VkApi.profileInfo(accessToken, userId), String.class);
    }

}
