package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete;

import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.Television;
import org.springframework.stereotype.Component;

@Component
public class TelevisionCompleteMapper {


  public Television toEntity(TelevisionCompleteInputDto televisionCompleteInputDto) {
    Television television = new Television();

    television.setBrand(televisionCompleteInputDto.getBrand());
    television.setName(televisionCompleteInputDto.getName());
    television.setPrice(televisionCompleteInputDto.getPrice());
    television.setAvailableSize(televisionCompleteInputDto.getAvailableSize());
    television.setRefreshRate(televisionCompleteInputDto.getRefreshRate());
    television.setScreenType(televisionCompleteInputDto.getScreenType());
    television.setScreenQuality(televisionCompleteInputDto.getScreenQuality());
    television.setSmartTV(televisionCompleteInputDto.isSmartTV());
    television.setWifi(televisionCompleteInputDto.isWifi());
    television.setVoiceControl(televisionCompleteInputDto.isVoiceControl());
    television.setHdr(televisionCompleteInputDto.isHdr());
    television.setBluetooth(televisionCompleteInputDto.isBluetooth());
    television.setAmbiLight(televisionCompleteInputDto.isAmbiLight());
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
    televisionCompleteOutputDTO.setSmartTV(television.isSmartTV());
    televisionCompleteOutputDTO.setWifi(television.isWifi());
    televisionCompleteOutputDTO.setVoiceControl(television.isVoiceControl());
    televisionCompleteOutputDTO.setHdr(television.isHdr());
    televisionCompleteOutputDTO.setBluetooth(television.isBluetooth());
    televisionCompleteOutputDTO.setAmbiLight(television.isAmbiLight());
    televisionCompleteOutputDTO.setOriginalStock(television.getOriginalStock());
    televisionCompleteOutputDTO.setSold(television.getSold());
    televisionCompleteOutputDTO.setSoldDate(television.getSoldDate());
    televisionCompleteOutputDTO.setPriceWithVat(television.getPrice());
    televisionCompleteOutputDTO.setDaysSinceSold(television.getSoldDate());

    return televisionCompleteOutputDTO;
  }


}
