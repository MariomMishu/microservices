package com.bs0842.accounts.exception;

import com.bs0842.accounts.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    // handle global exception
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception ex, WebRequest webRequest) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Business or user defined exception
    @ExceptionHandler(value = CustomerAlreadyExistException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistsException(CustomerAlreadyExistException ex, WebRequest webRequest) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest webRequest) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
