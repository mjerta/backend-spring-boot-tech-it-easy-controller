package nl.mpdev.backend_spring_boot_tech_it_easy_controller.mappers;

import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.TelevisionBaseDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.Television;

public interface TelevisionMapper<T extends TelevisionBaseDto, E extends TelevisionBaseDto> {
    Television toEntity(T dto);
    E toDto(Television television);
}
