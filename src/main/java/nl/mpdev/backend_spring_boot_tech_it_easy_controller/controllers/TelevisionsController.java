package nl.mpdev.backend_spring_boot_tech_it_easy_controller.controllers;

import nl.mpdev.backend_spring_boot_tech_it_easy_controller.exceptions.RecordNotFoundException;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.exceptions.StringTooLongException;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TelevisionsController {

  List<Television> televisionDataBase = new ArrayList<>();

  @GetMapping("/televisions")
  public ResponseEntity<List<Television>> getAllTelevisions() {
//    Map<String, String> response = new HashMap<>();
//    response.put("television 1","Toshiba");
//    response.put("television 2", "LG");
    return ResponseEntity.ok(televisionDataBase);
  }

  @GetMapping("/televisions/{id}")
  public ResponseEntity<Television> getTelevisionById(@PathVariable("id") int id) {
    if (findTelevisionById(id) == null) {
      throw new RecordNotFoundException();
    }
    return ResponseEntity.ok(findTelevisionById(id));
  }

  @PostMapping("/televisions")
  public ResponseEntity<Integer> postTelevision(@RequestBody String television) {
    if (television.length() > 20) {
      throw new StringTooLongException("This string is way too long");
    }
    Television newTV = new Television(television);
    televisionDataBase.add(newTV);
    return ResponseEntity.status(HttpStatus.CREATED).body(newTV.getId());
  }

  @PutMapping("/televisions/{id}")
  public ResponseEntity<Integer> putTelevision(@PathVariable int id, @RequestBody String television) {
    if (television.length() > 20) {
      throw new StringTooLongException("This string is way too long");
    }
    else if (findTelevisionById(id) == null) {
      // If the id does not exist a new record will be inserted
      Television newTV = new Television(television);
      televisionDataBase.add(newTV);
      return ResponseEntity.status(HttpStatus.CREATED).body(newTV.getId());
    }
    findTelevisionById(id).setModel(television);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @DeleteMapping("/televisions/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteTelevision(@PathVariable int id) {
    if (findTelevisionById(id) == null) {
      throw new RecordNotFoundException("Television not found");
    }
    televisionDataBase.remove(findTelevisionById(id));
  }

  private Television findTelevisionById(int id) {
    for (Television tv : televisionDataBase) {
      if (tv.getId() == id) {
        return tv;
      }
    }
    return null;
  }

}
