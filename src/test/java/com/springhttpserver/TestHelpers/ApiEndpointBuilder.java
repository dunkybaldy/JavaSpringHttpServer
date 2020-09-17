package com.springhttpserver.TestHelpers;

import java.net.URI;

public class ApiEndpointBuilder {

    private String current;

    public ApiEndpointBuilder(String baseUrl)
    {
        current = baseUrl;
    }

    public ApiEndpointBuilder Add(String toAdd) {
        current += toAdd;
        return this;
    }

    public String Build() { return current; }
}
