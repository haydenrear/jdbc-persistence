package com.hayden.jdbc_persistence.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class JsonJdbcConfig extends AbstractJdbcConfiguration {

    @Autowired(required = false)
    private List<JsonReadConverter> readConverters = new ArrayList<>();
    @Autowired(required = false)
    private List<JsonWriteConverter> writeConverters = new ArrayList<>();

    @Override
    protected List<?> userConverters() {
        List<Converter> r = new ArrayList<>(readConverters);
        r.addAll(writeConverters);
        return r;
    }

}
