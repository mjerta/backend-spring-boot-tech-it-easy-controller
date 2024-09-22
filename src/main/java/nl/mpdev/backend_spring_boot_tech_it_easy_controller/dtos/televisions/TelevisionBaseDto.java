package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class TelevisionBaseDto {
  @Getter @Setter
  private Integer id;
  @Getter @Setter
  @NotEmpty(message = "This field is required.")
  private String brand;
  @Getter @Setter
  @Size(max= 20, message = "Name cant be longer then 20 characters.")
  private String name;

}
