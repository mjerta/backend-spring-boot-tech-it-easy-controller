package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.wallbrackets;

import lombok.Data;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete.TelevisionCompleteInputDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete.TelevisionCompleteOutputDTO;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.Television;

import java.util.ArrayList;
import java.util.List;
@Data
public class WallBracketCompleteInputDto {
  private Long id;
  private String size;
  private Boolean adjustable;
  private String name;
  private Double price;
  private List<TelevisionCompleteOutputDTO> televisionCompleteOutputDTOS = new ArrayList<>();

}
