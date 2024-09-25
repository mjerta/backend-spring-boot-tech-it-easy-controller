package nl.mpdev.backend_spring_boot_tech_it_easy_controller.mappers;

public interface BaseMapper {
  Object toEntity(Object dto);
  Object toDto(Object entity);

}
