package com.hayden.jdbc_persistence.config;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.postgresql.util.PGobject;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

import java.util.Map;

@ReadingConverter
public interface JsonReadConverter<T extends PgJson<U>, U> extends Converter<PGobject, T> {

    @RequiredArgsConstructor
    @Component
    @ReadingConverter
    @Slf4j
    class JsonMapReadConverter implements JsonReadConverter<PgJson.MapPgJson, Map<String, Object>> {

        private static final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public PgJson.MapPgJson convert(PGobject pGobject) {
            try {
                return objectMapper.readValue(pGobject.getValue(), new TypeReference<>() {});
            } catch (JsonProcessingException e) {
                log.error("Error when converting PgJson.MapPgJson to PGobject", e);
                throw new RuntimeException(e);
            }
        }
    }

}
