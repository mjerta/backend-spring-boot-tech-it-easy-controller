package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.sales;

import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.TelevisionBaseDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.mappers.Mapper;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.Television;
import org.springframework.stereotype.Component;

@Component
public class TelevisionSalesMapper implements Mapper<TelevisionSalesInputDto, TelevisionSalesOutputDto> {

  public Television toEntity(TelevisionSalesInputDto televisionSalesInputDto) {
    Television television = new Television();

    television.setBrand(televisionSalesInputDto.getBrand());
    television.setName(televisionSalesInputDto.getName());
    television.setPrice(televisionSalesInputDto.getPrice());
    television.setOriginalStock(televisionSalesInputDto.getOriginalStock());
    television.setSold(televisionSalesInputDto.getSold());
    return television;
  }

  public TelevisionSalesOutputDto toDto(Television television) {
    TelevisionSalesOutputDto televisionSalesOutputDto = new TelevisionSalesOutputDto();
    televisionSalesOutputDto.setId(television.getId());
    televisionSalesOutputDto.setBrand(television.getBrand());
    televisionSalesOutputDto.setName(television.getName());
    televisionSalesOutputDto.setPrice(television.getPrice());
    televisionSalesOutputDto.setOriginalStock(television.getOriginalStock());
    televisionSalesOutputDto.setSold(television.getSold());
    return televisionSalesOutputDto;
  }
}
