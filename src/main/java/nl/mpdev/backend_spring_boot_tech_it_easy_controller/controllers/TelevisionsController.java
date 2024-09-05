package nl.mpdev.backend_spring_boot_tech_it_easy_controller.controllers;

import jakarta.servlet.annotation.HttpConstraint;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TelevisionsController {

  List<String> televisionDataBase = new ArrayList<>();

  @GetMapping("/televisions")
  public ResponseEntity<List<String>> getAllTelevisions() {
//    Map<String, String> response = new HashMap<>();
//    response.put("television 1","Toshiba");
//    response.put("television 2", "LG");
    return ResponseEntity.ok(televisionDataBase);
  }

  @GetMapping("/televisions/{id}")
  public ResponseEntity<String> getTelevisionById(@PathVariable("id") int id) {
    if (id < 0 || id >= televisionDataBase.size()) {
      throw new RecordNotFoundException("Record is not found");
    }
    return ResponseEntity.ok(televisionDataBase.get(id));
  }

  @PostMapping("/televisions")
  public ResponseEntity<String> postTelevision(@RequestBody String television) {
    televisionDataBase.add(television);
    return ResponseEntity.status(HttpStatus.CREATED).body(television);
  }

  @PutMapping("/televisions/{id}")
  public ResponseEntity<Object> putTelevision(@PathVariable int id, @RequestBody String television) {
    if (id < 0 || id >= televisionDataBase.size()) {
      // If the id does not exist a new record will be inserted
      televisionDataBase.add(television);
      return ResponseEntity.status(HttpStatus.CREATED).body(television);
    }
    televisionDataBase.set(id, television);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @DeleteMapping("/televisions/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteTelevision(@PathVariable int id) {
    if (id < 0 || id >= televisionDataBase.size()) {
      throw new RecordNotFoundException("Record is not found");
    }
    televisionDataBase.remove(televisionDataBase.get(id));
  }
}
