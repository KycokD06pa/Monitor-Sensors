package task.agsrTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.agsrTest.model.Sensor;
import task.agsrTest.model.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {

}
