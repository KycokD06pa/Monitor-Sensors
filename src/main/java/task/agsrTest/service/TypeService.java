package task.agsrTest.service;

import org.springframework.stereotype.Service;
import task.agsrTest.model.Sensor;
import task.agsrTest.model.Type;

import java.util.List;


public interface TypeService {

    void update(Type type);
    List<Type> getAll();
    void addType(Type type);
    Type findById(Long id);
    void delete(Type type);
}
