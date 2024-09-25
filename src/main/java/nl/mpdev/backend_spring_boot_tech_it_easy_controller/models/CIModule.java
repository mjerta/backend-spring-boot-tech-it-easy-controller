package nl.mpdev.backend_spring_boot_tech_it_easy_controller.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "CImodules")
public class CIModule {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String type;
  private Double price;
}
