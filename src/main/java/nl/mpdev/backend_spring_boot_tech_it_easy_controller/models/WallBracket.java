package nl.mpdev.backend_spring_boot_tech_it_easy_controller.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Wallbrackets")
public class WallBracket {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String size;
  private Boolean adjustable;
  private String name;
  private Double price;

}
