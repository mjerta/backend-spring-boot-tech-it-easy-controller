package nl.mpdev.backend_spring_boot_tech_it_easy_controller.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Remotes")
public class Remote {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String compatibleWith;
  private String batteryType;
  private String brand;
  private Double price;
  private Integer originalStock;


}
