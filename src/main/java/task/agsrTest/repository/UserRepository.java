package task.agsrTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.agsrTest.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String userName);
}