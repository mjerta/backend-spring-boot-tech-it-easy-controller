package nl.mpdev.backend_spring_boot_tech_it_easy_controller.exceptions;


public class StringTooLongException extends RuntimeException{

  public StringTooLongException() {
    // Default message
    super("String is too long!");
  }

  public StringTooLongException(String message) {
    super(message);
  }
}
