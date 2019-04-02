package ru.jointvibe.mainwebservice.vk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.json.JSONObject;

@AllArgsConstructor
@Getter
public class VkUser {

    public static final String USER_ID = "user_id";
    public static final String TOKEN = "access_token";

    public VkUser(JSONObject userJson) {
        this.userId = userJson.getInt(USER_ID);
        this.token = userJson.getString(TOKEN);
    }

    private int userId;
    private String token;
}
