package nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.enums;

public enum AvailableSize {
  SIZE_32(32), // Calls the Constructor and puts in the value of 32
  SIZE_40(40),
  SIZE_50(50),
  SIZE_55(55),
  SIZE_65(65),
  SIZE_75(75),
  SIZE_85(85);

  private final int size;
  AvailableSize(final int size) {
    this.size = size;
  }

}
