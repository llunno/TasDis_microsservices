package com.ln.microsservice.gateway.Business.Exceptions;

import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.net.ConnectException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentTypeMismatchException;

@RestControllerAdvice
class GeneralExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ResponseEntity<?> handleNullPointerException(NullPointerException e) {
        return new ResponseEntity<>("Recurso não encontrado. Explicação: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MissingPathVariableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ResponseEntity<?> handleInternalServerErrorException(MissingPathVariableException e) {
        return new ResponseEntity<>("Parâmetro incorreto. Explicação: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return new ResponseEntity<>("Parâmetro incorreto. Explicação: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>("Parâmetro incorreto. Explicação: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConnectException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private ResponseEntity<?> handleConnectException(ConnectException e) {
        return new ResponseEntity<>("Serviço indisponível no momento. Por favor, tente novamente mais tarde.",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(WebClientRequestException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private ResponseEntity<?> handleWebClientConnectException(WebClientRequestException e) {
        return new ResponseEntity<>("Serviço indisponível no momento. Por favor, tente novamente mais tarde.",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(WebClientResponseException.class)
    private ResponseEntity<?> handleWebClientResponseException(WebClientResponseException e) {
        if (e.getStatusCode().isSameCodeAs(HttpStatusCode.valueOf(404))) {
            return new ResponseEntity<>("Recurso não encontrado.", HttpStatus.NOT_FOUND);
        } else if (e.getStatusCode().is4xxClientError()) {
            return new ResponseEntity<>("Erro na requisição. Verifique se os dados e a formatação estão corretos e tente novamente", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Erro interno no servidor. Tente novamente mais tarde.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
