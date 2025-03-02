package com.hayden.jdbc_persistence.config;

import lombok.SneakyThrows;
import org.postgresql.util.PGobject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class JsonConverter implements Converter<PGJson, PGobject> {

    @SneakyThrows
    @Override
    public PGobject convert(PGJson source) {
        var p = new PGobject();
        p.setType("json");
        p.setValue(source.value());
        return p;
    }
}
