package com.ln.microsservice.tarefa.Business.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointerException(NullPointerException e) {
        if (e.getMessage().contains("nao encontrada") || e.getMessage().contains("not found")
                || e.getMessage().contains("não encontrado")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
