package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete;

import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.cimodules.CIModuleCompleteMapper;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.remotes.RemoteCompleteMapper;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.wallbrackets.WallBracketCompleteMapper;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.mappers.TelevisionMapper;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.Television;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.WallBracket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TelevisionCompleteTelevisionMapper implements TelevisionMapper<TelevisionCompleteInputDto, TelevisionCompleteOutputDTO> {

  @Autowired
  private RemoteCompleteMapper remoteCompleteMapper;
  @Autowired
  private CIModuleCompleteMapper ciModuleCompleteMapper;
  @Autowired
  private WallBracketCompleteMapper wallBracketCompleteMapper;

  public Television toEntity(TelevisionCompleteInputDto televisionCompleteInputDto) {
    Television television = new Television();

    television.setBrand(televisionCompleteInputDto.getBrand());
    television.setName(televisionCompleteInputDto.getName());
    television.setPrice(televisionCompleteInputDto.getPrice());
    television.setAvailableSize(televisionCompleteInputDto.getAvailableSize());
    television.setRefreshRate(televisionCompleteInputDto.getRefreshRate());
    television.setScreenType(televisionCompleteInputDto.getScreenType());
    television.setScreenQuality(televisionCompleteInputDto.getScreenQuality());
    television.setSmartTV(televisionCompleteInputDto.getSmartTV());
    television.setWifi(televisionCompleteInputDto.getWifi());
    television.setVoiceControl(televisionCompleteInputDto.getVoiceControl());
    television.setHdr(televisionCompleteInputDto.getHdr());
    television.setBluetooth(televisionCompleteInputDto.getBluetooth());
    television.setAmbiLight(televisionCompleteInputDto.getAmbiLight());
    television.setOriginalStock(televisionCompleteInputDto.getOriginalStock());
    television.setSold(televisionCompleteInputDto.getSold());
    television.setSoldDate(televisionCompleteInputDto.getSoldDate());
    return television;

  }

  public TelevisionCompleteOutputDTO toDto(Television television) {
    TelevisionCompleteOutputDTO televisionCompleteOutputDTO = new TelevisionCompleteOutputDTO();
    televisionCompleteOutputDTO.setId(television.getId());
    televisionCompleteOutputDTO.setBrand(television.getBrand());
    televisionCompleteOutputDTO.setName(television.getName());
    televisionCompleteOutputDTO.setPrice(television.getPrice());
    televisionCompleteOutputDTO.setAvailableSize(television.getAvailableSize());
    televisionCompleteOutputDTO.setRefreshRate(television.getRefreshRate());
    televisionCompleteOutputDTO.setScreenType(television.getScreenType());
    televisionCompleteOutputDTO.setScreenQuality(television.getScreenQuality());
    televisionCompleteOutputDTO.setSmartTV(television.getSmartTV());
    televisionCompleteOutputDTO.setWifi(television.getWifi());
    televisionCompleteOutputDTO.setVoiceControl(television.getVoiceControl());
    televisionCompleteOutputDTO.setHdr(television.getHdr());
    televisionCompleteOutputDTO.setBluetooth(television.getBluetooth());
    televisionCompleteOutputDTO.setAmbiLight(television.getAmbiLight());
    televisionCompleteOutputDTO.setOriginalStock(television.getOriginalStock());
    televisionCompleteOutputDTO.setSold(television.getSold());
    televisionCompleteOutputDTO.setSoldDate(television.getSoldDate());
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
