package task.agsrTest.service;

import task.agsrTest.model.Sensor;

import java.util.List;

public interface SensorService {

    void update(Sensor sensor);
    List<Sensor> getAll();
    void addSensor(Sensor sensor);
    List<Sensor> findByName(String sensorName);
    List<Sensor> findByModel(String sensorName);
    void delete(Sensor sensor);

}
