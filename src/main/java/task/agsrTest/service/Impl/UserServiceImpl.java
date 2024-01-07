package task.agsrTest.service.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaQuery;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task.agsrTest.model.Unit;
import task.agsrTest.model.User;
import task.agsrTest.repository.UserRepository;
import task.agsrTest.service.UserService;
import javax.annotation.PostConstruct;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public void addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(User user) {
        User updateUser = repository.findById(user.getId()).orElse(null);
        if(updateUser != null){
            updateUser.setName(user.getName());
            updateUser.setPassword(encoder.encode(user.getPassword()));
            updateUser.setRole(user.getRole());
            repository.save(updateUser);
        }
    }

    @Override
    @Transactional
    public void delete(User user) {
        repository.delete(user);
    }


    public UserServiceImpl(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }
}
