package com.placa.mae.placamae.controller.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.placa.mae.placamae.services.exceptions.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExeptionHandler {
    
        @ExceptionHandler(EntityNotFoundException.class)
        public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException err, HttpServletRequest request) {
            StandardError error = new StandardError();
            error.setTimestamp(Instant.now());
            error.setStatus(HttpStatus.NOT_FOUND.value());
            error.setError(err.getMessage());
            error.setMessage(err.getMessage());
            error.setPath(request.getRequestURI());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }

}
