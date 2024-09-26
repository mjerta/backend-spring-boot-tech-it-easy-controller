package nl.mpdev.backend_spring_boot_tech_it_easy_controller.services;

import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.general.IdInputDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete.TelevisionCompleteInputDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete.TelevisionCompleteTelevisionMapper;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete.TelevisionCompleteOutputDTO;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.sales.TelevisionSalesInputDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.sales.TelevisionSalesTelevisionMapper;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.sales.TelevisionSalesOutputDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.exceptions.GeneralException;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.exceptions.RecordNotFoundException;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.CIModule;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.Remote;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.Television;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.WallBracket;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.repositories.CIModuleRepository;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.repositories.RemoteRepository;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.repositories.TelevisionRepository;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.repositories.WallBracketRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TelevisionService {

  private final TelevisionRepository televisionRepository;
  private final RemoteRepository remoteRepository;
  private final CIModuleRepository ciModuleRepository;
  private final WallBracketRepository wallBracketRepository;
  private final TelevisionCompleteTelevisionMapper televisionCompleteMapper;
  private final TelevisionSalesTelevisionMapper televisionSalesMapper;

  public TelevisionService(TelevisionRepository televisionRepository, RemoteRepository remoteRepository,
                           CIModuleRepository ciModuleRepository, WallBracketRepository wallBracketRepository, TelevisionCompleteTelevisionMapper televisionCompleteMapper,
                           TelevisionSalesTelevisionMapper televisionSalesMapper) {

    this.televisionRepository = televisionRepository;
    this.remoteRepository = remoteRepository;
    this.ciModuleRepository = ciModuleRepository;
    this.wallBracketRepository = wallBracketRepository;
    this.televisionCompleteMapper = televisionCompleteMapper;
    this.televisionSalesMapper = televisionSalesMapper;
  }

  public TelevisionCompleteOutputDTO getTelevision(Long id) {
    Television television = televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Record not found"));
    return televisionCompleteMapper.toDto(television);
  }

  public TelevisionSalesOutputDto getSalesTelevision(Long id) {
    Television television = televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Record not found"));
    return televisionSalesMapper.toDto(television);
  }

  public List<TelevisionCompleteOutputDTO> getTelevisions() {
    List<Television> televisions = televisionRepository.findAll();
    return televisions.stream().map(televisionCompleteMapper::toDto).collect(Collectors.toList());
  }

  public List<TelevisionSalesOutputDto> getTelevisionsSales() {
    List<Television> televisions = televisionRepository.findAll();
    return televisions.stream().map(televisionSalesMapper::toDto).collect(Collectors.toList());
  }

  public TelevisionCompleteOutputDTO addTelevision(TelevisionCompleteInputDto televisionCompleteInputDto) {
    Television television = televisionRepository.save(televisionCompleteMapper.toEntity(televisionCompleteInputDto));
    return televisionCompleteMapper.toDto(television);
  }

  public TelevisionSalesOutputDto addTelevisionSales(TelevisionSalesInputDto televisionSalesInputDto) {
    Television television = televisionRepository.save(televisionSalesMapper.toEntity(televisionSalesInputDto));
    return televisionSalesMapper.toDto(television);
  }

  // PUT

  public TelevisionCompleteOutputDTO updateTelevision(Long id, TelevisionCompleteInputDto televisionCompleteInputDto) {
    Television existingTelevision = televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Record not found"));
    BeanUtils.copyProperties(televisionCompleteInputDto, existingTelevision, "id");
    return televisionCompleteMapper.toDto(televisionRepository.save(existingTelevision));
  }

  public TelevisionSalesOutputDto updateTelevisionSales(Long id, TelevisionSalesInputDto televisionSalesInputDto) {
    Television existingTelevision = televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Record not found"));
    BeanUtils.copyProperties(televisionSalesInputDto, existingTelevision, "id");
    return televisionSalesMapper.toDto(televisionRepository.save(existingTelevision));
  }

  public TelevisionCompleteOutputDTO updateTelevisionWithRemote(Long id, IdInputDto idInputDto) {
    Television television = televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Television not found"));
    Remote remote = remoteRepository.findById(idInputDto.id).orElseThrow(() -> new RecordNotFoundException("Remote not found"));
    television.setRemote(remote);
    return televisionCompleteMapper.toDto(televisionRepository.save(television));
  }

  public TelevisionCompleteOutputDTO updateTelevisionWithCIModule(Long id, IdInputDto idInputDto) {
    Television television = televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Television not found"));
    CIModule ciModule = ciModuleRepository.findById(idInputDto.id).orElseThrow(() -> new RecordNotFoundException("CI module not found"));
    television.setCiModule(ciModule);
    return televisionCompleteMapper.toDto(televisionRepository.save(television));
  }

  public TelevisionCompleteOutputDTO updateTelevisionWithWallBracket(Long id, List<IdInputDto> idInputDtoList) {
    Television television = televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Television not found"));
    List<WallBracket> wallBracketsFound = new ArrayList();
    for (IdInputDto idInputDto : idInputDtoList) {
      wallBracketsFound.add(
        wallBracketRepository.findById(idInputDto.id).orElseThrow(() -> new RecordNotFoundException("Wallbracket module not found"))
      );
    }
    television.setWallBrackets(wallBracketsFound);
    return televisionCompleteMapper.toDto(televisionRepository.save(television));
  }

  // patch

  public TelevisionCompleteOutputDTO updateTelevisionFields(Long id, TelevisionCompleteInputDto televisionCompleteInputDto) {
    Television existingTelevision = televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Record not found"));
    setFieldsIfNotNUll(existingTelevision, televisionCompleteInputDto);
    return televisionCompleteMapper.toDto(televisionRepository.save(existingTelevision));
  }

  public TelevisionSalesOutputDto updateTelevisionSalesFields(Long id, TelevisionSalesInputDto televisionSalesInputDto) {
    Television existingTelevision = televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Record not found"));
    setFieldsIfNotNUll(existingTelevision, televisionSalesInputDto);
    return televisionSalesMapper.toDto(televisionRepository.save(existingTelevision));
  }

  public void deleteTelevision(Long id) {
    Television existingTelevision = televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Record not found"));
    televisionRepository.deleteById(id);
  }

  // Helper class to check if one of the fields is null and therefor not being set
  // The one that is not null can only replace the field of the existing record

  private void setFieldsIfNotNUll(Object existingObject, Object incomingObject) {
    Field[] fields = incomingObject.getClass().getDeclaredFields();
    for (Field dtoField : fields) {
      dtoField.setAccessible(true);
      try {
        Object value = dtoField.get(incomingObject);

        if (value != null) {
          Field enityField = existingObject.getClass().getDeclaredField(dtoField.getName());
          enityField.setAccessible(true);
          enityField.set(existingObject, value);
        }
      } catch (IllegalAccessException e) {
        // This is about if the fields are accesisble and are being private or not
        throw new GeneralException("Cannot acces fields: " + dtoField.getName());
      } catch (NoSuchFieldException e) {
        // This is about if the field name are not the same in this case
        throw new GeneralException("Field not found: " + dtoField.getName());
      }
    }
  }

}
