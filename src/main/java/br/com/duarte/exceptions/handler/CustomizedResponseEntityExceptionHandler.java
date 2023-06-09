package br.com.duarte.exceptions.handler;

import br.com.duarte.exceptions.ExceptionResponse;
import br.com.duarte.exceptions.RequiredObjectIsNullException;
import br.com.duarte.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception exception, WebRequest request){
        var exceptionResponse = ExceptionResponse.builder()
                .timestamp(new Date())
                .message(exception.getMessage())
                .details(request.getDescription(false))
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(Exception exception, WebRequest request){
        var exceptionResponse = ExceptionResponse.builder()
                .timestamp(new Date())
                .message(exception.getMessage())
                .details(request.getDescription(false))
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RequiredObjectIsNullException.class)
    public final ResponseEntity<ExceptionResponse> handleRequiredObjectIsNullException(Exception exception, WebRequest request){
        var exceptionResponse = ExceptionResponse.builder()
                .timestamp(new Date())
                .message(exception.getMessage())
                .details(request.getDescription(false))
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
