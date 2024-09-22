package nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.complete;

import lombok.Getter;
import lombok.Setter;
import nl.mpdev.backend_spring_boot_tech_it_easy_controller.dtos.televisions.sales.TelevisionSalesInputDto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
@Getter
@Setter
public class TelevisionCompleteOutputDTO extends TelevisionCompleteInputDto {

  private Double priceWithVat;
  private Long daysSinceSold;
  private Integer valueOfAvailableSize;


  private long calculateDaysBetweenSold(LocalDate oldDate) {
    return ChronoUnit.DAYS.between(oldDate, LocalDate.now());
  }

  public void setPriceWithVat(Double oldPrice) {
    this.priceWithVat = oldPrice * 1.21;
  }

  public void setDaysSinceSold(LocalDate oldDate) {
    this.daysSinceSold = calculateDaysBetweenSold(super.getSoldDate());
  }
}

