package ru.jointvibe.mainwebservice.vk.request.builder;

import ru.jointvibe.mainwebservice.vk.request.params.BasicParams;

public class VkApiRequestBuilder {

    public static final String API_URL = "https://api.vk.com/";
    public static final String METHOD = "method/";
    public static final String API_METHOD = API_URL + METHOD;
    public static final String USER_INFO = "users.get";

    public static BasicParams profileInfo(){
        return new BasicParams(API_METHOD + USER_INFO);
    }
}
