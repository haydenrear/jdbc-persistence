package com.hayden.jdbc_persistence.config;

import org.postgresql.util.PGobject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class JsonReadConverter implements Converter<PGobject, PGJson> {

    @Override
    public PGJson convert(PGobject source) {
        return new PGJson(source.getValue());
    }


}
