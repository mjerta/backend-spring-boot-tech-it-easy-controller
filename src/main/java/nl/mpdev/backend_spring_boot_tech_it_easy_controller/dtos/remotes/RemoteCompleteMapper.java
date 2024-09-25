package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.remotes;

import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.Remote;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RemoteCompleteMapper {

  public Remote toEntity(RemoteCompleteInputDto remoteCompleteInputDto) {
    Remote remote = new Remote();
    BeanUtils.copyProperties(remote, remoteCompleteInputDto);
    remote.setId(null);
    return remote;
  }

  public RemoteCompleteOutputDto toDto(Remote remote) {
    RemoteCompleteOutputDto remoteCompleteOutputDto = new RemoteCompleteOutputDto();
    BeanUtils.copyProperties(remote, remoteCompleteOutputDto);
    return remoteCompleteOutputDto;
  }

}
