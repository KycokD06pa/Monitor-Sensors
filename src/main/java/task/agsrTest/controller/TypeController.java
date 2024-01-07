package task.agsrTest.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import task.agsrTest.model.Type;
import task.agsrTest.service.SensorService;
import task.agsrTest.service.TypeService;

import java.util.List;

@RestController
@RequestMapping("agsr/test/sensors/types")
public class TypeController {

    private final TypeService service;

    @GetMapping
    @PreAuthorize("hasAuthority('Administrator')")
    public List<Type> findAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('Administrator')")
    public Type getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('Administrator')")
    public void addType(@RequestBody Type type) {
        service.addType(type);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('Administrator')")
    public void updateType(@RequestBody Type type) {
        service.update(type);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('Administrator')")
    public void deleteType(@RequestBody Type type){
        service.delete(type);
    }


    public TypeController(TypeService service) {
        this.service = service;
    }

}
