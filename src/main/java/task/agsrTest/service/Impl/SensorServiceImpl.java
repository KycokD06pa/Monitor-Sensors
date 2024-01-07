package task.agsrTest.service.Impl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import task.agsrTest.exception.ValueException;
import task.agsrTest.model.Sensor;
import task.agsrTest.repository.Searching.SensorSearchingRepository;
import task.agsrTest.repository.SensorRepository;
import task.agsrTest.service.SensorService;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    private final SensorRepository repository;
    private final SensorSearchingRepository searchingRepository;

    @Override
    @Transactional
    public void update(Sensor sensor) {
        Sensor updateSensor = repository.findById(sensor.getId()).orElse(null);
        if(updateSensor != null){
            updateSensor.setName(sensor.getName());
            updateSensor.setDescription(sensor.getDescription());
            updateSensor.setLocation(sensor.getLocation());
            try {
                updateSensor.setRangeFrom(sensor.getRangeFrom());
                updateSensor.setRangeTo(sensor.getRangeTo());
            } catch (ValueException e) {
                throw new RuntimeException(e);
            }
            updateSensor.setModel(sensor.getModel());
            updateSensor.setUnit(sensor.getUnit());
            updateSensor.setType(sensor.getType());
            repository.save(updateSensor);
        }
    }

    @Override
    public List<Sensor> getAll() {
        return repository.findAll();
    }

    @Override
    public void addSensor(Sensor sensor) {
        repository.save(sensor);
        System.out.println("save");
    }

    @Override

    public List<Sensor> findByName(String sensorName) {
        return searchingRepository.getByNameContaining(sensorName);
    }

    @Override
    public List<Sensor> findByModel(String model) {
        return searchingRepository.getByModelContains(model);
    }

    @Override
    @Transactional
    public void delete(Sensor sensor) {
        repository.delete(sensor);
    }

    public SensorServiceImpl(SensorRepository repository, EntityManager entityManager, SensorSearchingRepository searchingRepository) {
        this.repository = repository;
        this.searchingRepository = searchingRepository;

    }

}
