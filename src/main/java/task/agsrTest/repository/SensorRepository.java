package task.agsrTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import task.agsrTest.model.Sensor;
import task.agsrTest.model.Type;
import task.agsrTest.model.Unit;
import task.agsrTest.model.User;
import task.agsrTest.service.Impl.SensorServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor, Long> {


}
