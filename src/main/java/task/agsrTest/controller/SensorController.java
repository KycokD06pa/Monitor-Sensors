package task.agsrTest.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import task.agsrTest.config.MapperUtil;
import task.agsrTest.dto.RangeDto;
import task.agsrTest.dto.SensorDto;
import task.agsrTest.dto.TypeDto;
import task.agsrTest.dto.UnitDto;
import task.agsrTest.model.Sensor;
import task.agsrTest.model.Type;
import task.agsrTest.model.Unit;
import task.agsrTest.service.SensorService;

import java.util.List;

@RestController
@RequestMapping("agsr/test/sensors")
public class SensorController {

    private final SensorService service;
    private final ModelMapper modelMapper;

    @GetMapping(value = "")
    @PreAuthorize("hasAnyAuthority('Administrator','Viewer')")
    @Operation(
            summary = "метод для вывода всех датчиков по примеру",
            description = "метод для вывода всех датчиков по примеру"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "успешно")
    })
    public List<SensorDto> findAll(){
        List<Sensor> sensors = service.getAll();
        return MapperUtil.convertList(sensors, this::convertToSensorDto);

    }

    @GetMapping("/original")
    @PreAuthorize("hasAnyAuthority('Administrator','Viewer')")
    @Operation(
            summary = "метод для вывода всех датчиков",
            description = "метод для вывода всех датчиков по изначальному json"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "успешно")
    })
    public List<Sensor> findAllOriginal(){
        return  service.getAll();
    }

    @GetMapping("original/name/{title}")
    @PreAuthorize("hasAnyAuthority('Administrator','Viewer')")
    @Operation(
            summary = "метод для вывода датчиков по имени",
            description = "метод для вывода датчиков по имени по изначальному json"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "успешно")
    })
    public List<Sensor> getByNameOriginal(@PathVariable String title) {
        return service.findByName(title);
    }

    @GetMapping("original/model/{title}")
    @PreAuthorize("hasAnyAuthority('Administrator','Viewer')")
    @Operation(
            summary = "метод для вывода датчиков по моедели",
            description = "метод для вывода датчиков по модели по изначальному json"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "успешно")
    })
    public List<Sensor> getByModelOriginal(@PathVariable String title) {
        return service.findByModel(title);
    }


    @GetMapping("name/{title}")
    @PreAuthorize("hasAnyAuthority('Administrator','Viewer')")
    @Operation(
            summary = "метод для вывода датчиков по имени по примеру",
            description = "метод для вывода датчиков по имени по примеру"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "успешно")
    })
    public List<SensorDto> getByName(@PathVariable String title) {
        List<Sensor> sensors = service.findByName(title);
        return MapperUtil.convertList(sensors, this::convertToSensorDto);
    }
    @GetMapping("model/{title}")
    @PreAuthorize("hasAnyAuthority('Administrator','Viewer')")
    @Operation(
            summary = "метод для вывода датчиков по модели по примеру",
            description = "метод для вывода датчиков по модели по примеру"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "успешно")
    })
    public List<SensorDto> getByModel(@PathVariable String title) {

        List<Sensor> sensors = service.findByModel(title);
        return MapperUtil.convertList(sensors, this::convertToSensorDto);
    }


    @PostMapping("/save")
    @PreAuthorize("hasAuthority('Administrator')")
    @Operation(
            summary = "метод для добавления датчика",
            description = "метод для добавления датчика"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "успешно")
    })
    public void addSensor(@RequestBody Sensor sensor) {
        service.addSensor(sensor);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('Administrator')")
    @Operation(
            summary = "метод для обновления датчика",
            description = "метод для обновления информации о датчике через объект"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "успешно")
    })
    public void updateSensor(@RequestBody Sensor sensor) {
        service.update(sensor);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('Administrator')")
    @Operation(
            summary = "метод для удаления датчика ",
            description = "метод для удаления датчика через объект"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "успешно")
    })
    public void deleteSensor(@RequestBody Sensor sensor){
        service.delete(sensor);
    }


    public SensorController(SensorService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }




    private SensorDto convertToSensorDto(Sensor sensor) {
        SensorDto sensorDto = modelMapper.map(sensor, SensorDto.class);
        sensorDto.setTypeDto(convertToTypeDto(sensor.getType()));
        sensorDto.setUnitDto(convertToUnitDto(sensor.getUnit()));
        sensorDto.setRangeDto(new RangeDto(sensor.getRangeFrom(), sensor.getRangeTo()));
        return sensorDto;
    }
    private TypeDto convertToTypeDto(Type type) {
        return modelMapper.map(type, TypeDto.class);
    }
    private UnitDto convertToUnitDto(Unit unit) {
        return modelMapper.map(unit, UnitDto.class);
    }
}
