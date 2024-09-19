package nl.mpdev.backend_spring_boot_tech_it_easy_controller.services;

import jakarta.persistence.EntityNotFoundException;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete.TelevisionCompleteInputDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete.TelevisionCompleteMapper;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete.TelevisionCompleteOutputDTO;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.sales.TelevisionSalesInputDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.sales.TelevisionSalesMapper;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.sales.TelevisionSalesOutputDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.exceptions.RecordNotFoundException;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.Television;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.repositories.TelevisionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TelevisionService {

  private final TelevisionRepository televisionRepository;
  private final TelevisionCompleteMapper televisionCompleteMapper;
  private final TelevisionSalesMapper televisionSalesMapper;

  public TelevisionService(TelevisionRepository televisionRepository, TelevisionCompleteMapper televisionCompleteMapper,
                           TelevisionSalesMapper televisionSalesMapper) {

    this.televisionRepository = televisionRepository;
    this.televisionCompleteMapper = televisionCompleteMapper;
    this.televisionSalesMapper = televisionSalesMapper;
  }

  public TelevisionCompleteOutputDTO getTelevision(int id) {
    Television television = televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Record not found"));
    return televisionCompleteMapper.toDto(television);
  }

  public TelevisionSalesOutputDto getSalesTelevision(int id) {
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

  public TelevisionCompleteOutputDTO updateTelevision(int id, TelevisionCompleteInputDto televisionCompleteInputDto) {
    Television existingTelevision = televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Record not found"));
    BeanUtils.copyProperties(televisionCompleteInputDto, existingTelevision, "id");
    return televisionCompleteMapper.toDto(televisionRepository.save(existingTelevision));
  }

  public TelevisionSalesOutputDto updateTelevision(int id, TelevisionSalesInputDto televisionSalesInputDto) {
    Television existingTelevision = televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Record not found"));
    BeanUtils.copyProperties(televisionSalesInputDto, existingTelevision, "id");
    return televisionSalesMapper.toDto(televisionRepository.save(existingTelevision));
  }

  public void deleteTelevision(int id) {
    televisionRepository.deleteById(id);
  }

}
