package task.agsrTest.service.Impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import task.agsrTest.model.Sensor;
import task.agsrTest.model.Type;
import task.agsrTest.repository.TypeRepository;
import task.agsrTest.service.TypeService;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    private final TypeRepository repository;


    @Override
    public void update(Type type) {
        Type updateType = repository.findById(type.getId()).orElse(null);
        if(updateType != null){
            updateType.setName(type.getName());
            repository.save(updateType);
        }
    }

    @Override
    public List<Type> getAll() {
        return repository.findAll();
    }

    @Override
    public void addType(Type type) {
        repository.save(type);
    }

    @Override
    public Type findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Type type) {
        repository.delete(type);
    }


    public TypeServiceImpl(TypeRepository repository) {
        this.repository = repository;
    }

}
