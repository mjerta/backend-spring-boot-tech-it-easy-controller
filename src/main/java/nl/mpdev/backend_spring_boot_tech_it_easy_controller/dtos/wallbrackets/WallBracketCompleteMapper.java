package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.wallbrackets;

import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.WallBracket;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WallBracketCompleteMapper {

  public WallBracket toEntity(WallBracketCompleteInputDto inputDto) {
    WallBracket wallBracket = new WallBracket();
    BeanUtils.copyProperties(inputDto, wallBracket);
    wallBracket.setId(null);
    return wallBracket;
  }

  public WallbracketCompleteOutputDto toDto(WallBracket wallBracket) {
    WallbracketCompleteOutputDto outputDto = new WallbracketCompleteOutputDto();
    BeanUtils.copyProperties(wallBracket, outputDto);
    return outputDto;
  }

  public List<WallbracketCompleteOutputDto> toDTo(List<WallBracket> wallBrackets) {
    List<WallbracketCompleteOutputDto> outputDtos = new ArrayList<>();
    for(WallBracket wallBracket : wallBrackets) {
      WallbracketCompleteOutputDto dto = new WallbracketCompleteOutputDto();
      BeanUtils.copyProperties(wallBracket, dto);
      outputDtos.add(dto);
    }
    return outputDtos;
  }

}
