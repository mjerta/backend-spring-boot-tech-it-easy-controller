package nl.mpdev.backend_spring_boot_tech_it_easy_controller.exceptions;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsController {

//  @ExceptionHandler(value = IndexOutOfBoundsException.class)
//  public ResponseEntity<Object> handleException(IndexOutOfBoundsException ex) {
//    HttpStatus status = HttpStatus.I_AM_A_TEAPOT;
//    return new ResponseEntity<>("Exception id not found in list", status);
//  }

  @ExceptionHandler(RecordNotFoundException.class)
  public ResponseEntity<Object> handleException(RecordNotFoundException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }
}
