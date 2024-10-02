package com.ln.microsservice.gateway.Business.APiResponses;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiResponsePattern {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp = LocalDateTime.now();
    private String message;
    private Object data;

    public ApiResponsePattern(String message) {
        this.message = message;
        this.data = List.of();
    }

    public ApiResponsePattern(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}