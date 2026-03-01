package edu.tdse.lab5;

import java.util.Collections;
import java.util.Map;

public class Request {
    private final String path;
    private final Map<String, String> queryParams;

    public Request(String path, Map<String, String> queryParams) {
        this.path = path;
        this.queryParams = queryParams != null ? queryParams : Collections.emptyMap();
    }

    public String getPath() {
        return path;
    }

    // El enunciado usa getValues("name")
    public String getValues(String key) {
        return queryParams.get(key);
    }

    public Map<String, String> getQueryParams() {
        return Collections.unmodifiableMap(queryParams);
    }
}