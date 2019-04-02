package ru.jointvibe.mainwebservice.vk;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.jointvibe.mainwebservice.vk.request.VkApi;

import java.io.IOException;

@Component
public class AuthClient {

    @Autowired
    private Users users;

    public VkUser getToken(String code) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpResponse response = client.execute(new HttpGet(VkApi.token(code)));
            VkUser user = new VkUser(new JSONObject(EntityUtils.toString(response.getEntity())));
            users.addUser(user);
            return user;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
