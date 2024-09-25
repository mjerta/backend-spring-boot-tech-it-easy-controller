package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.cimodules;

import jakarta.persistence.OneToMany;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.Television;

import java.util.List;

public class CIModuleCompleteInputDto {
  private Long id;
  private String name;
  private String type;
  private Double price;
  private List<Long> televisionsId;
}
