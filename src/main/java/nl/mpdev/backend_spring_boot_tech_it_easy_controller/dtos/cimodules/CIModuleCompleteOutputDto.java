package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.cimodules;

import lombok.Data;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete.TelevisionCompleteOutputDTO;

import java.util.List;

@Data
public class CIModuleCompleteOutputDto {
  private Long id;
  private String name;
  private String type;
  private Double price;
}
