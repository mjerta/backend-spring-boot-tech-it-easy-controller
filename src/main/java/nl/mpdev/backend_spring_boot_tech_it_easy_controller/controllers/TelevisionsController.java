package nl.mpdev.backend_spring_boot_tech_it_easy_controller.controllers;

import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete.TelevisionCompleteOutputDTO;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.exceptions.RecordNotFoundException;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.exceptions.StringTooLongException;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.Television;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.services.TelevisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TelevisionsController {

//  List<Television> televisionDataBase = new ArrayList<>();

  private final TelevisionService televisionService;

  public TelevisionsController(TelevisionService televisionService) {
    this.televisionService = televisionService;
  }

  // GET
  @GetMapping("/televisions/{id}")
  public ResponseEntity<TelevisionCompleteOutputDTO> getTelevisionById(@PathVariable int id) {
    return ResponseEntity.ok().body(televisionService.getTelevision(id));
  }

  @GetMapping("/televisions")
  public ResponseEntity<List<Television>> getTelevisions() {
    return ResponseEntity.ok().body(televisionService.getTelevisions());
  }

  // POST
  @PostMapping("/televisions")
  public ResponseEntity<Object> addTelevision(@RequestBody Television television) {

    isNameTooLong(television);
    Television newTelevision = televisionService.addTelevision(television);
    return ResponseEntity.status(HttpStatus.CREATED).body(newTelevision);
  }

  // PUT
  @PutMapping("/televisions/{id}")
  public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody Television television) {
    isNameTooLong(television);
    return ResponseEntity.ok().body(televisionService.updateTelevision(id ,television));
  }

  @DeleteMapping("/televisions/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteTelevision(@PathVariable int id) {
    televisionService.deleteTelevision(id);
  }

  private void isNameTooLong(Television television) {
    if (television.getName().length() >= 20) {
      throw new StringTooLongException("This string is way too long");
    }
  }
}
