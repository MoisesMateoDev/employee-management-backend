package net.javaguides.employee_backend.exception;

import net.javaguides.employee_backend.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e) throws ResourceNotFoundException {
        ErrorResponse errorResponse = new ErrorResponse(
                e.getExceptionType(),
                LocalDateTime.now(),
                e.getMessage(),
                "Try another employeeId or verify the current one.",
                e.getStackTrace()
                );
        return new ResponseEntity<>(
                errorResponse,
                HttpStatus.NOT_FOUND
        );
    }

}