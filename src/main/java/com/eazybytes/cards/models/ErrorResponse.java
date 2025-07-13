package com.eazybytes.cards.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse
{
    private String path;

    private HttpStatus status;

    private String message;

    private LocalDateTime timestamp;
}
