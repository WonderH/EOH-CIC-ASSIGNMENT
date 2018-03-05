package za.co.eoh.andile.cic.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import za.co.eoh.andile.cic.exception.DataNotFoundException;

@ControllerAdvice
@RestController
public class ExceptionResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),500, ex.getMessage(),
        request.getDescription(false));
    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(DataNotFoundException.class)
  public final ResponseEntity<ExceptionResponse> handleDataNotFoundException(DataNotFoundException ex, WebRequest request) {
    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),404, ex.getMessage(),
        request.getDescription(false));
    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }

}
