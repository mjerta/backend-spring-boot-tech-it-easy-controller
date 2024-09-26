package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.remotes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoteCompleteInputDto {
  private Long id;
  private String compatibleWith;
  private String batteryType;
  private String brand;
  private Double price;
  private Integer originalStock;
}
