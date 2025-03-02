package com.hayden.jdbc_persistence.config;

import java.util.Map;

/**
 * Represent json in DB by using this - future generic?
 * @param value
 */
public interface PgJson<T> {
    T value();

    record MapPgJson(Map<String, Object> value) implements PgJson<Map<String, Object>> {}

}
