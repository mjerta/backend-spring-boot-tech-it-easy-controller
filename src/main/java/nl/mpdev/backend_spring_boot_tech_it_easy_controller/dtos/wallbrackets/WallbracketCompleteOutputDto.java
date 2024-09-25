package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.wallbrackets;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class WallbracketCompleteOutputDto {
  private Long id;
  private String size;
  private Boolean adjustable;
  private String name;
  private Double price;
  private List<Long> televisionsIds = new ArrayList<>();
}
