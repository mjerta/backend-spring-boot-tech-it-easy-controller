package nl.mpdev.backend_spring_boot_tech_it_easy_controller.controllers;

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
  public ResponseEntity<Television> getTelevisionById(@PathVariable int id) {
    Optional<Television> television =  televisionService.getTelevision(id);
    if (television.isPresent()) {
      return new ResponseEntity<>(television.get(), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @GetMapping("/televisions")
  public ResponseEntity<List<Television>> getTelevisions() {
    return ResponseEntity.ok().body(televisionService.getTelevisions());
  }

//  POST
  @PostMapping("/televisions")
  public ResponseEntity<Object> addTelevision(@RequestBody Television television) {

    if(television.getName().length() >= 20) {
      throw new StringTooLongException("This string is way too long");
    }
    Television newTelevision = televisionService.addTelevision(television);
    return ResponseEntity.status(HttpStatus.CREATED).body(newTelevision.getId());
  }
//  @GetMapping("/televisions/{id}")
//  public ResponseEntity<Television> getTelevisionById(@PathVariable("id") int id) {
//    if (findTelevisionById(id) == null) {
//      throw new RecordNotFoundException();
//    }
//    return ResponseEntity.ok(findTelevisionById(id));
//  }
//
//  @PostMapping("/televisions")
//  public ResponseEntity<Integer> postTelevision(@RequestBody String television) {
//    if (television.length() > 20) {
//      throw new StringTooLongException("This string is way too long");
//    }
//    Television newTV = new Television(television);
//    televisionDataBase.add(newTV);
//    return ResponseEntity.status(HttpStatus.CREATED).body(newTV.getId());
//  }
//
//  @PutMapping("/televisions/{id}")
//  public ResponseEntity<Integer> putTelevision(@PathVariable int id, @RequestBody String television) {
//    if (television.length() > 20) {
//      throw new StringTooLongException("This string is way too long");
//    }
//    else if (findTelevisionById(id) == null) {
//      // If the id does not exist a new record will be inserted
//      Television newTV = new Television(television);
//      televisionDataBase.add(newTV);
//      return ResponseEntity.status(HttpStatus.CREATED).body(newTV.getId());
//    }
//    findTelevisionById(id).setModel(television);
//    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//  }
//
//  @DeleteMapping("/televisions/{id}")
//  @ResponseStatus(HttpStatus.NO_CONTENT)
//  public void deleteTelevision(@PathVariable int id) {
//    if (findTelevisionById(id) == null) {
//      throw new RecordNotFoundException("Television not found");
//    }
//    televisionDataBase.remove(findTelevisionById(id));
//  }
//
//  private Television findTelevisionById(int id) {
//    for (Television tv : televisionDataBase) {
//      if (tv.getId() == id) {
//        return tv;
//      }
//    }
//    return null;
//  }

}
