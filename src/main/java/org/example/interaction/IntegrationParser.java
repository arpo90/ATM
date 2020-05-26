package org.example.interaction;

import java.util.Optional;

public interface IntegrationParser {
    Optional<String> saveObject(Object o);

    Optional<Object> getObject(String s, Class c);
}
