package ru.jointvibe.mainwebservice.vk.request.params;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang.StringUtils.join;

public abstract class RequestParams {

    protected String destination;

    protected Map<String, String> params = new HashMap<>();

    public RequestParams(String destination) {
        this.destination = destination;
    }

    public abstract RequestParams apiVerison(String apiVersion);

    public String build() {
        return destination + "?" + join(convertParamsMap(), "&");
    }

    private List<String> convertParamsMap(){
        return params.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue()).collect(toList());
    }
}
