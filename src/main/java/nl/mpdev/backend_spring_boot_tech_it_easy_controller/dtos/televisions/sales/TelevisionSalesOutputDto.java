package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.sales;

import lombok.Getter;
import lombok.Setter;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.TelevisionBaseDto;

@Getter
@Setter
public class TelevisionSalesOutputDto extends TelevisionBaseDto {
  private Double price;
  private Integer originalStock;
  private Integer sold;

}
