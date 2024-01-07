package task.agsrTest.service;

import task.agsrTest.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void addUser(User user);
    User findById(Long id);
    void update(User user);
    void delete(User user);

}
