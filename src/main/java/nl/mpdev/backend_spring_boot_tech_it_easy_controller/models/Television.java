package nl.mpdev.backend_spring_boot_tech_it_easy_controller.models;

import jakarta.persistence.*;
import lombok.Data;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.enums.AvailableSize;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.enums.RefreshRate;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.enums.ScreenQuality;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.enums.ScreenType;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "Televisions")
public class Television {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String brand;
  private String name;
  private Double price;
  // This is optional in this case. Its a default.
//  @Enumerated(EnumType.ORDINAL)
  private AvailableSize availableSize;
  private RefreshRate refreshRate;
  private ScreenType screenType;
  private ScreenQuality screenQuality;
  private Boolean smartTV;
  private Boolean wifi;
  private Boolean voiceControl;
  private Boolean hdr;
  private Boolean bluetooth;
  private Boolean ambiLight;
  private Integer originalStock;
  private Integer sold;
  private LocalDate soldDate;
  @OneToOne(cascade = CascadeType.ALL)
  // remote_id is also the default based on the attribute name + the _id
  // Also the referencedColumnname the default will be assigned to the primary key of the target enitty
  @JoinColumn(name = "remote_id", referencedColumnName = "id")
  private Remote remote;


  // EAGER: Loads all associated entities immediately. Good for known required associations but can lead to performance issues with large graphs.
  // LAZY: Loads associated entities on demand. Generally better for performance but requires careful management to avoid performance pitfalls.
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "cimodule_id")
  private CIModule ciModule;


  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) // Use PERSIST and MERGE to handle new and existing associations
  @JoinTable(
    name = "television_wallbrackets",
    // By default the name gets the of the owners class name + _id
    joinColumns = @JoinColumn(name = "television"),
    // Also this column name ar by default the name of Field name + _id
    inverseJoinColumns = @JoinColumn(name = "wallbracket")
  )
  private List<WallBracket> wallBrackets;
}
