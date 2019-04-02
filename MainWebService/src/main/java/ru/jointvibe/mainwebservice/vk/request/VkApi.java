package ru.jointvibe.mainwebservice.vk.request;

public class VkApi {

    private static final String CLIENT_ID = "6923333";
    private static final String LOCAL_URI = "http://jvtest.ru:1111";
    private static final String TOKEN = "/token";
    private static final String RESPONSE_TYPE = "code";
    private static final String API_VERSION = "5.92";
    private static final String CLIENT_SECRET = "phEXI0rV3SDmRBRZnH10";

    public static String auth(){
        return RequestBuilder.auth()
                .clientId(CLIENT_ID)
                .display("page")
                .redirectUri(LOCAL_URI + TOKEN)
                .scope("friends")
                .responseType(RESPONSE_TYPE)
                .apiVerison(API_VERSION)
                .build();
    }

    public static String token(String code){
        return RequestBuilder.token()
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .redirectUri(LOCAL_URI + TOKEN)
                .code(code)
                .build();
    }
}
