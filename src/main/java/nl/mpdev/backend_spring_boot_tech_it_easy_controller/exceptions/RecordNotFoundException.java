package nl.mpdev.backend_spring_boot_tech_it_easy_controller.exceptions;

import lombok.Getter;

@Getter
public class RecordNotFoundException extends RuntimeException {
  public RecordNotFoundException(String message) {
    super(message);
  }

}
