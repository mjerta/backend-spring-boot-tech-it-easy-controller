package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.cimodules;

import lombok.Data;

@Data
public class CIModuleCompleteInputDto {
  private Long id;
  private String name;
  private String type;
  private Double price;
}
