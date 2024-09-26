package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.cimodules;

import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.remotes.RemoteCompleteInputDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.remotes.RemoteCompleteOutputDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.CIModule;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.Remote;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CIModuleCompleteMapper {

  public CIModule toEntity(CIModuleCompleteInputDto ciModuleCompleteInputDto) {
    CIModule ciModule = new CIModule();
    BeanUtils.copyProperties(ciModule, ciModuleCompleteInputDto);
    ciModule.setId(null);
    return ciModule;
  }

  public CIModuleCompleteOutputDto toDto(CIModule ciModule) {
    CIModuleCompleteOutputDto ciModuleCompleteOutputDto = new CIModuleCompleteOutputDto();
    BeanUtils.copyProperties(ciModule, ciModuleCompleteOutputDto);
    return ciModuleCompleteOutputDto;
  }
}
