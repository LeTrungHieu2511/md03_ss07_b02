package com.example.md03.exception;

import com.example.md03.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidation(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        for (FieldError fe : ex.getBindingResult().getFieldErrors()) {
            // Một field có nhiều lỗi thì giữ lỗi đầu tiên
            errors.putIfAbsent(fe.getField(), fe.getDefaultMessage());
        }

        ApiResponse<Map<String, String>> body =
                new ApiResponse<>("error", "Dữ liệu không hợp lệ", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}