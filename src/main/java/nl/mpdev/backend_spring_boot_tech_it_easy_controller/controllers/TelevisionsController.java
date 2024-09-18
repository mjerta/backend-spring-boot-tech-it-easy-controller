package nl.mpdev.backend_spring_boot_tech_it_easy_controller.controllers;

import jakarta.validation.Valid;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete.TelevisionCompleteInputDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete.TelevisionCompleteOutputDTO;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.sales.TelevisionSalesInputDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.sales.TelevisionSalesOutputDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.exceptions.RecordNotFoundException;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.exceptions.StringTooLongException;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.Television;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.services.TelevisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

  //   specially for sales (controller REST endpoint)
  @GetMapping("/sales/{id}")
  public ResponseEntity<TelevisionSalesOutputDto> getTelevisionSalesById(@PathVariable int id) {
    return ResponseEntity.ok().body(televisionService.getSalesTelevision(id));
  }

  @GetMapping("/televisions")
  public ResponseEntity<List<TelevisionCompleteOutputDTO>> getTelevisions() {
    return ResponseEntity.ok().body(televisionService.getTelevisions());
  }

  // POST
  @PostMapping("/televisions")
  public ResponseEntity<TelevisionCompleteOutputDTO> addTelevision(@Valid @RequestBody TelevisionCompleteInputDto televisionCompleteInputDto) {
    TelevisionCompleteOutputDTO newTelevision = televisionService.addTelevision(televisionCompleteInputDto);
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + newTelevision.getId()).toUriString());
    return ResponseEntity.created(uri).body(newTelevision);
  }

  // PUT
  @PutMapping("/televisions/{id}")
  public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody Television television) {
    return ResponseEntity.ok().body(televisionService.updateTelevision(id, television));
  }

  @DeleteMapping("/televisions/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteTelevision(@PathVariable int id) {
    televisionService.deleteTelevision(id);
  }

}
