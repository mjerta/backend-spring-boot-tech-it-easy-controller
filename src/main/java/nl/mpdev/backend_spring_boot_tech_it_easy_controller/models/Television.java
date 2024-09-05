package nl.mpdev.backend_spring_boot_tech_it_easy_controller.models;

import lombok.Getter;

@Getter
public class Television {
  // Simulating the counter from an automatic increment from a database
  private static  int idCounter;
  private int id;
  private String model;
  private int price;

  public Television(String model) {
    this.id = ++idCounter;
    this.model = model;
  }

  public Television(String model, int price) {
    this.id = ++idCounter;
    this.model = model;
    this.price = price;

  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
