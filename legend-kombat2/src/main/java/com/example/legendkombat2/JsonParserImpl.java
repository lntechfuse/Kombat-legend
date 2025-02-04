package com.example.legendkombat2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonParserImpl implements JsonParser {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T fromJson(String json, Class<T> clazz) throws IOException {
        return objectMapper.readValue(json, clazz);
    }

    @Override
    public String toJson(Object object) throws IOException {
        return objectMapper.writeValueAsString(object);
    }
}
