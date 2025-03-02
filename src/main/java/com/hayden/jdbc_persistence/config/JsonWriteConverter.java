package com.hayden.jdbc_persistence.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.util.PGobject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Map;

public interface JsonWriteConverter<T extends PgJson<U>, U> extends Converter<T, PGobject> {

    @WritingConverter
    @Component
    @RequiredArgsConstructor
    @Slf4j
    class MapPgJsonConverter implements JsonWriteConverter<PgJson.MapPgJson, Map<String, Object>> {

        private static final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public PGobject convert(PgJson.MapPgJson source) {
            var p = new PGobject();
            p.setType("json");
            try {
                p.setValue(objectMapper.writeValueAsString(source));
                return p;
            } catch (SQLException | JsonProcessingException e) {
                log.error("Error when converting PgJson.MapPgJson to PGobject", e);
                throw new RuntimeException(e);
            }
        }
    }

}
