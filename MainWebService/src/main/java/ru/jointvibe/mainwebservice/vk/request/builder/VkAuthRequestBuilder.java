package ru.jointvibe.mainwebservice.vk.request.builder;

import ru.jointvibe.mainwebservice.vk.request.params.AuthParams;

public class VkAuthRequestBuilder {

    private static final String OAUTH_URL = "https://oauth.vk.com";

    private static final String AUTHORIZE = "/authorize";

    private static final String ACCESS_TOKEN = "/access_token";

    public static AuthParams auth() {
        return new AuthParams(OAUTH_URL + AUTHORIZE);
    }

    public static AuthParams token() {
        return new AuthParams(OAUTH_URL + ACCESS_TOKEN);
    }
}
