package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete;

import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.cimodules.CIModuleCompleteMapper;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.remotes.RemoteCompleteMapper;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.wallbrackets.WallBracketCompleteMapper;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.Television;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TelevisionCompleteMapper {

  @Autowired
  private RemoteCompleteMapper remoteCompleteMapper;
  @Autowired
  private CIModuleCompleteMapper ciModuleCompleteMapper;
  @Autowired
  private WallBracketCompleteMapper wallBracketCompleteMapper;

  public Television toEntity(TelevisionCompleteInputDto televisionCompleteInputDto) {
    Television television = new Television();
    BeanUtils.copyProperties(televisionCompleteInputDto, television);
    television.setId(null);
    return television;

  }

  public TelevisionCompleteOutputDTO toDto(Television television) {
    TelevisionCompleteOutputDTO televisionCompleteOutputDTO = new TelevisionCompleteOutputDTO();
    BeanUtils.copyProperties(television, televisionCompleteOutputDTO);
    if (television.getWallBrackets() != null) {
      televisionCompleteOutputDTO.setWallbracketCompleteOutputDtos(wallBracketCompleteMapper.toDTo(television.getWallBrackets()));
    }
    if (television.getCiModule() != null) {
      televisionCompleteOutputDTO.setCiModuleCompleteOutputDto(ciModuleCompleteMapper.toDto(television.getCiModule()));
    }
    if (television.getRemote() != null) {
      televisionCompleteOutputDTO.setRemoteCompleteOutputDto(remoteCompleteMapper.toDto(television.getRemote()));
    }
    if (televisionCompleteOutputDTO.getAvailableSize() != null) {
      televisionCompleteOutputDTO.setValueOfAvailableSize(television.getAvailableSize().getSize());
    }
    if (television.getPrice() != null) {
      televisionCompleteOutputDTO.setPriceWithVat(television.getPrice());
    }
    if (television.getSoldDate() != null) {
      televisionCompleteOutputDTO.setDaysSinceSold(television.getSoldDate());
    }
    return televisionCompleteOutputDTO;
  }
}
