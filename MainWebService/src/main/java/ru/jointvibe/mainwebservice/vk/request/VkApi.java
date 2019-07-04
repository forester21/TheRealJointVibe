package ru.jointvibe.mainwebservice.vk.request;

import ru.jointvibe.mainwebservice.vk.request.builder.VkApiRequestBuilder;
import ru.jointvibe.mainwebservice.vk.request.builder.VkAuthRequestBuilder;

public class VkApi {

    private static final String CLIENT_ID = "6923333";
    private static final String LOCAL_URI = "http://jvtest.ru:1111";
    public static final String TOKEN_URL = "/api/auth/token";
    private static final String RESPONSE_TYPE = "code";
    private static final String API_VERSION = "5.92";
    private static final String CLIENT_SECRET = "phEXI0rV3SDmRBRZnH10";

    public static String auth(){
        return VkAuthRequestBuilder.auth()
                .clientId(CLIENT_ID)
                .display("page")
                .redirectUri(LOCAL_URI + TOKEN_URL)
                .scope("friends")
                .responseType(RESPONSE_TYPE)
                .apiVerison(API_VERSION)
                .build();
    }

    public static String token(String code){
        return VkAuthRequestBuilder.token()
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .redirectUri(LOCAL_URI + TOKEN_URL)
                .code(code)
                .build();
    }

    public static String profileInfo(String accessToken, int userId){
        return VkApiRequestBuilder.profileInfo()
                .apiVerison(API_VERSION)
                .accessToken(accessToken)
                .userId(userId)
                .build();
    }
}
