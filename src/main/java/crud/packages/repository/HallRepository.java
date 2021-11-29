package crud.packages.repository;

import crud.packages.model.Done.Branch;
import crud.packages.model.Done.Hall;
import crud.packages.model.Done.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HallRepository extends JpaRepository<Hall, Long> {
//    @Query("SELECT b FROM Hall h JOIN Branch b ON h.branch_id = b.id WHERE h.id = :id")
//    public Branch getHallBranch(@Param("id")long hallId);
}
