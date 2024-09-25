package nl.mpdev.backend_spring_boot_tech_it_easy_controller.controllers;

import jakarta.validation.Valid;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.general.IdInputDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete.TelevisionCompleteInputDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete.TelevisionCompleteOutputDTO;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.sales.TelevisionSalesInputDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.sales.TelevisionSalesOutputDto;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.services.TelevisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/televisions")
public class TelevisionsController {

//  List<Television> televisionDataBase = new ArrayList<>();

    private final TelevisionService televisionService;

    public TelevisionsController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    // GET
    @GetMapping("/{id}")
    public ResponseEntity<TelevisionCompleteOutputDTO> getTelevisionById(@PathVariable Long id) {
        return ResponseEntity.ok().body(televisionService.getTelevision(id));
    }

    //   specially for sales (controller REST endpoint)
    @GetMapping("/{id}/sales")
    public ResponseEntity<TelevisionSalesOutputDto> getTelevisionSalesById(@PathVariable Long id) {
        return ResponseEntity.ok().body(televisionService.getSalesTelevision(id));
    }

    @GetMapping("")
    public ResponseEntity<List<TelevisionCompleteOutputDTO>> getTelevisions() {
        return ResponseEntity.ok().body(televisionService.getTelevisions());
    }

    @GetMapping("/sales")
    public ResponseEntity<List<TelevisionSalesOutputDto>> getTelevisionsSales() {
        return ResponseEntity.ok().body(televisionService.getTelevisionsSales());
    }

    // POST
    @PostMapping("")
    public ResponseEntity<TelevisionCompleteOutputDTO> addTelevision(@Valid @RequestBody TelevisionCompleteInputDto televisionCompleteInputDto) {
        TelevisionCompleteOutputDTO newTelevision = televisionService.addTelevision(televisionCompleteInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + newTelevision.getId()).toUriString());
        return ResponseEntity.created(uri).body(newTelevision);
    }

    @PostMapping("/sales")
    public ResponseEntity<TelevisionSalesOutputDto> addTelevisionSales(@Valid @RequestBody TelevisionSalesInputDto televisionSalesInputDto) {
        TelevisionSalesOutputDto newTelevision = televisionService.addTelevisionSales(televisionSalesInputDto);
        // I try to figure out how i can give back the URI more dynamically for this case but I dont know how to do it yet.
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/televisions/" + newTelevision.getId() + "/sales").toUriString());
        return ResponseEntity.created(uri).body(newTelevision);
    }



    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<TelevisionCompleteOutputDTO> updateTelevision(@PathVariable Long id, @Valid @RequestBody TelevisionCompleteInputDto televisionCompleteInputDto) {
        return ResponseEntity.ok().body(televisionService.updateTelevision(id, televisionCompleteInputDto));
    }

    @PutMapping("/{id}/sales")
    public ResponseEntity<TelevisionSalesOutputDto> updateTelevisionSales(@PathVariable Long id, @Valid @RequestBody TelevisionSalesInputDto televisionSalesInputDto) {
        return ResponseEntity.ok().body(televisionService.updateTelevisionSales(id, televisionSalesInputDto));
    }

    @PutMapping("/{id}/remotes")
    public ResponseEntity<TelevisionCompleteOutputDTO> updateTelevisionWithRemote(@PathVariable Long id, @RequestBody IdInputDto idInputDto) {
        return ResponseEntity.ok().body(televisionService.updateTelevisionWithRemote(id, idInputDto));
    }

    // PATCH
    @PatchMapping("/{id}")
    public ResponseEntity<TelevisionCompleteOutputDTO> updateTelevisionFields(@PathVariable Long id, @Valid @RequestBody TelevisionCompleteInputDto televisionCompleteInputDto) {
        return ResponseEntity.ok().body(televisionService.updateTelevisionFields(id, televisionCompleteInputDto));
    }

    @PatchMapping("/{id}/sales")
    public ResponseEntity<TelevisionSalesOutputDto> updateTelevisionSalesFields(@PathVariable Long id, @Valid @RequestBody TelevisionSalesInputDto televisionSalesInputDto) {
        return ResponseEntity.ok().body(televisionService.updateTelevisionSalesFields(id, televisionSalesInputDto));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
    }

}
