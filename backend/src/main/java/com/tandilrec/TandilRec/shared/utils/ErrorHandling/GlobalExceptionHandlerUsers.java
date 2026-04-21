package com.tandilrec.TandilRec.shared.utils.ErrorHandling;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandlerUsers {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorDTOResponse> handleUserNotFoundException(BaseException ex, HttpServletRequest request){
        ErrorDTOResponse error = new ErrorDTOResponse();
        error.setErrorCode(ex.getErrorCode());
        error.setErrorMessage(ex.getMessage());
        error.setStatus(ex.getStatus().value());
        error.setTimestamp(Instant.now());
        error.setPath(request.getRequestURI());
        return new ResponseEntity<>(error, ex.getStatus());
    }
}
