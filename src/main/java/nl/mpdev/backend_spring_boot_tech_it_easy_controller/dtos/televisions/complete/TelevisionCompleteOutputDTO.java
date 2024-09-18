package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete;

import lombok.Getter;
import lombok.Setter;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.TelevisionBaseDto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
@Getter
@Setter
public class TelevisionCompleteOutputDTO extends TelevisionCompleteInputDto {

  private double priceWithVat;
  private long daysSinceSold;

  public TelevisionCompleteOutputDTO() {
    this.priceWithVat = super.getPrice() * .21;
    this.daysSinceSold = calulateDaysBetweenSold(super.getSoldDate());
  }

  private long calulateDaysBetweenSold(LocalDate oldDate) {
    return ChronoUnit.DAYS.between(oldDate, LocalDate.now());
  }
}
