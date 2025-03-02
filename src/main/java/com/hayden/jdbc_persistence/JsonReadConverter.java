package com.hayden.jdbc_persistence;

import lombok.SneakyThrows;
import org.postgresql.util.PGobject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;

@ReadingConverter
public class JsonReadConverter implements Converter<PGobject, JsonConverter.PGJson> {

    @Override
    public JsonConverter.PGJson convert(PGobject source) {
        return new JsonConverter.PGJson(source.getValue());
    }


}
