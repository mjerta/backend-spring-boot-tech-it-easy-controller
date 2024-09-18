package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.sales;

import lombok.Getter;
import lombok.Setter;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.TelevisionBaseDto;

@Getter
@Setter
public class TelevisionSalesInputDto extends TelevisionBaseDto {
  private double price;
  private int originalStock;
  private int sold;

}
