package nl.mpdev.backend_spring_boot_tech_it_easy_controller.repositories;

import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.CIModule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CIModuleRepository extends JpaRepository<CIModule, Long> {
}
