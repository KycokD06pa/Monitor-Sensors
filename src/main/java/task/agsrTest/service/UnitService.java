package task.agsrTest.service;

import task.agsrTest.model.Unit;

import java.util.List;

public interface UnitService {

    void update(Unit unit);
    List<Unit> getAll();
    void addUnit(Unit unit);
    Unit findById(Long id);
    void delete(Unit unit);
}
