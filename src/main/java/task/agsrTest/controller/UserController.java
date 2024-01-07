package task.agsrTest.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import task.agsrTest.model.User;
import task.agsrTest.service.UserService;

import java.util.List;

@RestController
@RequestMapping("agsr/test/users")
public class UserController {

    private final UserService service;

    @GetMapping
    @PreAuthorize("hasAuthority('Administrator')")
    public List<User> findAll(){
        return service.getAll();
    }

    @GetMapping("name/{id}")
    @PreAuthorize("hasAuthority('Administrator')")
    public User getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    //@PreAuthorize("hasAuthority('Administrator')")
    public void addUser(@RequestBody User user) {
        service.addUser(user);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('Administrator')")
    public void updateUser(@RequestBody User user) {
        service.update(user);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('Administrator')")
    public void deleteUser(@RequestBody User user){
        service.delete(user);
    }

    public UserController(UserService service) {
        this.service = service;
    }
}
