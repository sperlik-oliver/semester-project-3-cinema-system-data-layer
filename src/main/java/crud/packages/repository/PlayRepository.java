package crud.packages.repository;

import crud.packages.model.Entities.Play;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayRepository extends JpaRepository<Play, Long> {}
