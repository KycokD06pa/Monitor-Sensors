package task.agsrTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.agsrTest.model.Type;
import task.agsrTest.model.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long> {
}
