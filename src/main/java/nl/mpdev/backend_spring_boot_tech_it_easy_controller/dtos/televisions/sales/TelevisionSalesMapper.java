package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.sales;

import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.Television;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TelevisionSalesMapper {

  public TelevisionSalesOutputDto toDto(Television television) {
    TelevisionSalesOutputDto televisionSalesOutputDto = new TelevisionSalesOutputDto();
    BeanUtils.copyProperties(television, televisionSalesOutputDto);
    return televisionSalesOutputDto;
  }
}
