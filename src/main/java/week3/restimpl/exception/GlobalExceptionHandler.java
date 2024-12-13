package week3.restimpl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> hanldeNotFoundException() {
        return new ResponseEntity<>(
                new ExceptionResponse(000, "resource not found"),
                HttpStatus.NOT_FOUND
        );
    }
}
