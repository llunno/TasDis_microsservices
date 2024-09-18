package com.ln.microsservice.bff.Business.Exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<?> handleWebClientResponseException(WebClientResponseException ex) {
        if (ex.getStatusCode().isSameCodeAs(HttpStatusCode.valueOf(404))) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getMostSpecificCause().getMessage());
        }
        else {
            return ResponseEntity.status(ex.getStatusCode()).body("Erro ao acessar o serviço");
        }
    }
}
