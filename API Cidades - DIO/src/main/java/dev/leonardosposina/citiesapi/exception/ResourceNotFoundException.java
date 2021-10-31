package dev.leonardosposina.citiesapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Class classType, Long id) {
        super(String.format("%s with id %s not found", classType.getSimpleName(), id));
    }
}
