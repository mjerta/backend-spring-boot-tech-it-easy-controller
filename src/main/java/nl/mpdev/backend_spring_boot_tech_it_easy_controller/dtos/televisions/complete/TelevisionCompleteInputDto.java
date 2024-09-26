package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete;

import lombok.Getter;
import lombok.Setter;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.TelevisionBaseDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.enums.AvailableSize;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.enums.RefreshRate;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.enums.ScreenQuality;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.enums.ScreenType;
import java.time.LocalDate;

@Getter
@Setter
public class TelevisionCompleteInputDto extends TelevisionBaseDto {
  private Double price;
  private AvailableSize availableSize;
  private RefreshRate refreshRate;
  private ScreenType screenType;
  private ScreenQuality screenQuality;
  private Boolean smartTV;
  private Boolean wifi;
  private Boolean voiceControl;
  private Boolean hdr;
  private Boolean bluetooth;
  private Boolean ambiLight;
  private Integer originalStock;
  private Integer sold;
  private LocalDate soldDate;
}
