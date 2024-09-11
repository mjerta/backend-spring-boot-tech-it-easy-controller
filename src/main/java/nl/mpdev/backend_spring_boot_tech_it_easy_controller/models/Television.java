package nl.mpdev.backend_spring_boot_tech_it_easy_controller.models;

import jakarta.persistence.*;
import lombok.Data;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.enums.AvailableSize;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.enums.RefreshRate;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.enums.ScreenQuality;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.enums.ScreenType;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Televisions")
public class Television {
//   Simulating the counter from an automatic increment from a database
//  private static  int idCounter;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String brand;
  private String name;
  private double price;

  // This is optional in this case, I like to put it as a default
//  @Enumerated(EnumType.ORDINAL)
  private AvailableSize availableSize;
  private RefreshRate refreshRate;
  private ScreenType screenType;
  private ScreenQuality screenQuality;
  private boolean smartTV;
  private boolean wifi;
  private boolean voiceControl;
  private boolean hdr;
  private boolean bluetooth;
  private boolean ambiLight;
  private int originalStock;
  private int sold;
  private LocalDate soldDate;






//  public Television(String model) {
//    this.id = ++idCounter;
//    this.model = model;
//  }

//  public Television(String model, int price) {
//    this.id = ++idCounter;
//    this.model = model;
//    this.price = price;
//
//  }
//
//  public void setModel(String model) {
//    this.model = model;
//  }
//
//  public void setPrice(int price) {
//    this.price = price;
//  }
}
