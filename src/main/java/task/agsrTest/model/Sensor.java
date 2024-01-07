package task.agsrTest.model;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.lang.NonNull;
import jakarta.validation.constraints.Size;
import task.agsrTest.exception.ValueException;

import java.util.Objects;


@Entity
@Table(name = "sensors")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Size(min=3, max=30)
    private String name;
    @NonNull
    @Size(max=15)
    private String model;

    private Integer rangeFrom;
    private Integer rangeTo;

    @ManyToOne
    private Type type;
    @ManyToOne
    private Unit unit;

    private String location;
    private String description;




    public Sensor(Long id, @NonNull String name, @NonNull String model,  Type type, Unit unit, String location,
                  String description, Integer rangeFrom, Integer rangeTo) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.type = type;
        this.unit = unit;
        this.location = location;
        this.description = description;
        this.rangeTo = rangeTo;
        this.rangeFrom = rangeFrom;


    }

    public Sensor() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public Integer getRangeFrom() {
        return rangeFrom;
    }

    public void setRangeFrom(Integer rangeFrom) throws ValueException {
        if(rangeFrom > 0 && (this.rangeTo == null || this.rangeTo > rangeFrom))   this.rangeFrom = rangeFrom;
        else throw new ValueException();
    }

    public Integer getRangeTo() {
        return rangeTo;
    }

    public void setRangeTo(Integer rangeTo) throws ValueException {
        if(rangeTo > 0 && (this.rangeFrom == null || this.rangeFrom < rangeTo))  this.rangeTo = rangeTo;
        else throw new ValueException();
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getModel() {
        return model;
    }

    public void setModel(@NonNull String model) {
        this.model = model;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        return Objects.equals(id, sensor.id) && Objects.equals(name, sensor.name) && Objects.equals(model, sensor.model) && Objects.equals(rangeFrom, sensor.rangeFrom) && Objects.equals(rangeTo, sensor.rangeTo) && Objects.equals(type, sensor.type) && Objects.equals(unit, sensor.unit) && Objects.equals(location, sensor.location) && Objects.equals(description, sensor.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, model, rangeFrom, rangeTo, type, unit, location, description);
    }
}