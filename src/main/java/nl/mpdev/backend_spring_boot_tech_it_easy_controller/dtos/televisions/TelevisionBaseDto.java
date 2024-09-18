package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions;

import lombok.Getter;
import lombok.Setter;

public class TelevisionBaseDto {
  @Getter @Setter
  private int id;
  @Getter @Setter
  private String brand;
  @Getter @Setter
  private String name;

}
