package task.agsrTest.service.Impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import task.agsrTest.model.Type;
import task.agsrTest.model.Unit;
import task.agsrTest.repository.UnitRepository;
import task.agsrTest.service.UnitService;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

    private final UnitRepository repository;
    @Override
    public void update(Unit unit) {
        Unit updateUnit = repository.findById(unit.getId()).orElse(null);
        if(updateUnit != null){
            updateUnit.setName(unit.getName());
            repository.save(updateUnit);
        }
    }

    @Override
    public List<Unit> getAll() {
        return repository.findAll();
    }

    @Override
    public void addUnit(Unit unit) {
        repository.save(unit);
    }

    @Override
    public Unit findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Unit unit) {
        repository.delete(unit);
    }


    public UnitServiceImpl(UnitRepository repository) {
        this.repository = repository;
    }
}
