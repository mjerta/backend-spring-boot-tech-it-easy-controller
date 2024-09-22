package nl.mpdev.backend_spring_boot_tech_it_easy_controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionsController {

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ResponseEntity<Object> handleException(MethodArgumentNotValidException ex) {
      Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream().
        collect(Collectors.toMap(
          FieldError::getField,
          FieldError::getDefaultMessage
        ));
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
  }

  @ExceptionHandler(value = IndexOutOfBoundsException.class)
  public ResponseEntity<Object> handleException(IndexOutOfBoundsException ex) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    return new ResponseEntity<>("Exception id not found in list", status);
  }

  @ExceptionHandler(value = HttpMessageNotReadableException.class)
  public ResponseEntity<Object> handleException(HttpMessageNotReadableException ex) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    return new ResponseEntity<>("Invalid properties inside your request " + ex.getMessage() , status);
  }


  //custom exceptions

  @ExceptionHandler(RecordNotFoundException.class)
  public ResponseEntity<Object> handleException(RecordNotFoundException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(StringTooLongException.class)
  public ResponseEntity<Object> handleException(StringTooLongException ex) {
    // Just an experiment to use a different syntax
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
  }

  @ExceptionHandler(GeneralException.class)
  public ResponseEntity<Object> handleException(GeneralException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
  }

}
