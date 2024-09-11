package nl.mpdev.backend_spring_boot_tech_it_easy_controller.services;

import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.Television;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {


  private final TelevisionRepository televisionRepository;

  public TelevisionService(TelevisionRepository televisionRepository) {
    this.televisionRepository = televisionRepository;
  }

  public Optional<Television> getTelevision(int id) {
    return televisionRepository.findById(id);
  }

  public List<Television> getTelevisions() {
    return televisionRepository.findAll();
  }

  public Television addTelevision(Television television) {
    return televisionRepository.save(television);
  }

  public Television updateTelevision(Television television) {
    return televisionRepository.save(television);
  }

  public void deleteTelevision(int id) {
    televisionRepository.deleteById(id);
  }
}
