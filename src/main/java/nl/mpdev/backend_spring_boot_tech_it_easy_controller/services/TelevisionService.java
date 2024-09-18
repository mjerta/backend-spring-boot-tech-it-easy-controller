package nl.mpdev.backend_spring_boot_tech_it_easy_controller.services;

import jakarta.persistence.EntityNotFoundException;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete.TelevisionCompleteMapper;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete.TelevisionCompleteOutputDTO;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.exceptions.RecordNotFoundException;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.Television;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

  private final TelevisionRepository televisionRepository;
  private final TelevisionCompleteMapper televisionCompleteMapper;

  public TelevisionService(TelevisionRepository televisionRepository, TelevisionCompleteMapper televisionCompleteMapper) {

    this.televisionRepository = televisionRepository;
    this.televisionCompleteMapper = televisionCompleteMapper;
  }

  public TelevisionCompleteOutputDTO getTelevision(int id) {
    Television television = televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Record not found"));

//    return televisionRepository.findById(id);
    return televisionCompleteMapper.toDto(television);
  }

  public List<Television> getTelevisions() {
    return televisionRepository.findAll();
  }

  public Television addTelevision(Television television) {
    return televisionRepository.save(television);
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
