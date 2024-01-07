package task.agsrTest.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import task.agsrTest.model.Type;
import task.agsrTest.model.Unit;
import task.agsrTest.service.TypeService;
import task.agsrTest.service.UnitService;

import java.util.List;

@RestController
@RequestMapping("agsr/test/sensors/units")
public class UnitController {

    private final UnitService service;

    @GetMapping
    @PreAuthorize("hasAuthority('Administrator')")
    public List<Unit> findAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('Administrator')")
    public Unit getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('Administrator')")
    public void addUnit(@RequestBody Unit unit) {
        service.addUnit(unit);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('Administrator')")
    public void updateUnit(@RequestBody Unit unit) {
        service.update(unit);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('Administrator')")
    public void deleteUnit(@RequestBody Unit unit){
        service.delete(unit);
    }


    public UnitController(UnitService service) {
        this.service = service;
    }
}
