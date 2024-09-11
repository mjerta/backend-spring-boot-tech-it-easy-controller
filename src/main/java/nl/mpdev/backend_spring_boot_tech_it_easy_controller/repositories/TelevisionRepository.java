package nl.mpdev.backend_spring_boot_tech_it_easy_controller.repositories;

import nl.mpdev.backend_spring_boot_tech_it_easy_controller.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelevisionRepository extends JpaRepository<Television, Integer> {
}
