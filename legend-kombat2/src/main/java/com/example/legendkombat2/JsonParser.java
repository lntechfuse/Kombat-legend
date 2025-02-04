package com.example.legendkombat2;

import java.io.IOException;

public interface JsonParser {
    // แปลง JSON string ไปเป็น Java Object
    <T> T fromJson(String json, Class<T> clazz) throws IOException;

    // แปลง Java Object ไปเป็น JSON string
    String toJson(Object object) throws IOException;
}
