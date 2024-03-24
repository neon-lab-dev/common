package com.neonlab.common.api;

import com.google.gson.Gson;
import com.neonlab.common.expectations.InvalidInputException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.time.Instant;

@Slf4j
public abstract class AbstractApi<I, O> {

    @Autowired
    protected Gson gson;
    public O process(I request) throws InvalidInputException {
        logRequest(request);
        if (!validateInput(request)) {
            throw new IllegalArgumentException("Invalid input");
        }
        Instant startTime = Instant.now();
        O response = execute(request);
        Instant endTime = Instant.now();
        logResponse(response);
        logApiFinished(getApiName(), startTime, endTime);
        return response;
    }

    protected abstract O execute(I request) throws InvalidInputException;

    protected void logRequest(I request) {
        log.info("Api request: {}", obj2str(request));
    }

    protected void logResponse(O response) {
        log.info("Api response: {}", obj2str(response));
    }

    protected boolean validateInput(I request) {
        if (request != null && !(request instanceof Void)) {
            try {
                // Check if at least one field of input is not null
                for (java.lang.reflect.Field field : request.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    if (field.get(request) != null) {
                        return true; // At least one field is not null, so input is valid
                    }
                }
            } catch (IllegalAccessException e) {
                log.error("Error accessing fields of input", e);
                return false;
            }
        }
        return false; // All fields are null, so input is invalid
    }

    protected void logApiFinished(String apiName, Instant startTime, Instant endTime) {
        Duration duration = Duration.between(startTime, endTime);
        log.info("API '{}' finished at {}. Duration: {} milliseconds.", apiName, endTime, duration.toMillis());
    }

    protected String getApiName() {
        Service apiService = AnnotationUtils.findAnnotation(this.getClass(), Service.class);
        if (apiService == null) {
            return "";
        }
        return StringUtils.hasText(apiService.value()) ? apiService.value() : this.getClass().getName();
    }

    private String obj2str(Object object) {
        try {
            return gson.toJson(object);
        } catch (Exception e) {
            log.error("Unable to serialize: {}", object);
            return null;
        }
    }
}
