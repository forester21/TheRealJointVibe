package ru.jointvibe.mainwebservice.vk.request.params;

public class AuthParams extends RequestParams {

    public AuthParams(String destination) {
        super(destination);
    }

    public AuthParams clientId(String clientId) {
        params.put("client_id", clientId);
        return this;
    }

    public AuthParams display(String display) {
        params.put("display", display);
        return this;
    }

    public AuthParams redirectUri(String redirectUri) {
        params.put("redirect_uri", redirectUri);
        return this;
    }

    public AuthParams scope(String scope) {
        params.put("scope", scope);
        return this;
    }

    public AuthParams responseType(String responseType) {
        params.put("response_type", responseType);
        return this;
    }

    public AuthParams apiVerison(String apiVersion) {
        params.put("v", apiVersion);
        return this;
    }

    public AuthParams clientSecret(String clientSecret) {
        params.put("client_secret", clientSecret);
        return this;
    }

    public AuthParams code(String code) {
        params.put("code", code);
        return this;
    }
}
