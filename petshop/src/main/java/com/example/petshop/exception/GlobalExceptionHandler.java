package com.example.petshop.exception;

import com.example.petshop.exception.ClienteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // Centraliza a resposta e serializa automaticamente para JSON
public class GlobalExceptionHandler {

    // 1. Trata a exceção customizada de recurso não encontrado (404)
    @ExceptionHandler(ClienteException.class)
    public ResponseEntity<String> handleResourceNotFound( ClienteException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    }