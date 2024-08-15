package com.trifork.trireg.server.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class CopyUtil {

    public static ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public static <T, U> U transferToTarget(T source, Class<U> targetClass) {
        return objectMapper.convertValue(source, targetClass);
    }

    public static <T, U> U transferToTarget(T source, TypeReference<U> targetTypeReference) {
        return objectMapper.convertValue(source, targetTypeReference);
    }
}
