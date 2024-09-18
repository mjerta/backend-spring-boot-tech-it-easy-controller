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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

  public TelevisionCompleteOutputDTO addTelevision(TelevisionCompleteInputDto televisionCompleteInputDto) {
    Television television = televisionRepository.save(televisionCompleteMapper.toEntity(televisionCompleteInputDto));
    return televisionCompleteMapper.toDto(television);
  }

  public Television updateTelevision(int id, Television television) {
    findRecordById(id);
    return televisionRepository.save(television);
  }

  public void deleteTelevision(int id) {
    findRecordById(id);
    televisionRepository.deleteById(id);
  }

  private void findRecordById(int id) {
    if (!televisionRepository.existsById(id)) {
      throw new RecordNotFoundException("This record does not exist");
    }
  }
}
