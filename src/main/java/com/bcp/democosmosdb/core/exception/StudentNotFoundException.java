package com.bcp.democosmosdb.core.exception;

import java.text.MessageFormat;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String id) {
        super(MessageFormat.format("Usuario con id: {0} no encontrado", id));
    }
}
