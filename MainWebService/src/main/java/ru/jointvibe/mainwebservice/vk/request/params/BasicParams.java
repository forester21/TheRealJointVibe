package ru.jointvibe.mainwebservice.vk.request.params;

public class BasicParams extends RequestParams {

    public BasicParams(String destination) {
        super(destination);
    }

    public BasicParams apiVerison(String apiVersion) {
        params.put("v", apiVersion);
        return this;
    }

    public BasicParams accessToken(String accessToken) {
        params.put("access_token", accessToken);
        return this;
    }

    public BasicParams userId(Integer userId) {
        params.put("user_id", userId.toString());
        return this;
    }
}
