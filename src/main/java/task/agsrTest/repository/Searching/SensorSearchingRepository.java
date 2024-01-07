package task.agsrTest.repository.Searching;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import task.agsrTest.exception.ValueException;
import task.agsrTest.model.Sensor;
import task.agsrTest.model.Type;
import task.agsrTest.model.Unit;
import task.agsrTest.service.Impl.SensorServiceImpl;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SensorSearchingRepository {

    private final JdbcTemplate jdbcTemplate;

    public  List<Sensor> getByNameContaining(String sensorName)  {
        List<SupportSensor> query = jdbcTemplate.query("SELECT * FROM test.sensors where name like '%"+ sensorName +"%'", BeanPropertyRowMapper.newInstance(SupportSensor.class));
        List<Sensor> answer = new ArrayList<>();
        for (SupportSensor temp : query) {
            Sensor sensor = new Sensor();
            sensor.setId(temp.id);
            sensor.setName(temp.name);
            sensor.setModel(temp.model);
            try {
                sensor.setRangeFrom(temp.rangeFrom);
                sensor.setRangeTo(temp.rangeTo);
            } catch (ValueException e) {
                throw new RuntimeException(e);
            }
            sensor.setLocation(temp.location);
            sensor.setDescription(temp.Description);
            List<Type> type = jdbcTemplate.query("SELECT * FROM test.types where id = " + temp.type_id, BeanPropertyRowMapper.newInstance(Type.class));
            sensor.setType(type.get(0));
            List<Unit> unit = jdbcTemplate.query("SELECT * FROM test.units where id = " + temp.unit_id, BeanPropertyRowMapper.newInstance(Unit.class));
            sensor.setUnit(unit.get(0));
            answer.add(sensor);
        }
        return  answer;
    }
    public List<Sensor> getByModelContains(String model){
        List<SupportSensor> query = jdbcTemplate.query("SELECT * FROM test.sensors where model like '%"+ model +"%'", BeanPropertyRowMapper.newInstance(SupportSensor.class));
        List<Sensor> answer = new ArrayList<>();
        for (SupportSensor temp : query) {
            Sensor sensor = new Sensor();
            sensor.setId(temp.id);
            sensor.setName(temp.name);
            sensor.setModel(temp.model);
            try {
                sensor.setRangeFrom(temp.rangeFrom);
                sensor.setRangeTo(temp.rangeTo);
            } catch (ValueException e) {
                throw new RuntimeException(e);
            }
            sensor.setLocation(temp.location);
            sensor.setDescription(temp.Description);
            List<Type> type = jdbcTemplate.query("SELECT * FROM test.types where id = " + temp.type_id, BeanPropertyRowMapper.newInstance(Type.class));
            sensor.setType(type.get(0));
            List<Unit> unit = jdbcTemplate.query("SELECT * FROM test.units where id = " + temp.unit_id, BeanPropertyRowMapper.newInstance(Unit.class));
            sensor.setUnit(unit.get(0));
            answer.add(sensor);
        }
        return  answer;
    }


    public SensorSearchingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static class SupportSensor{
        private Long id;
        private String name;
        private String model;
        private Integer rangeFrom;
        private Integer rangeTo;

        private Long type_id;
        private Long unit_id;
        private String location;
        private String Description;

        public SupportSensor(){         }

        public SupportSensor(Long id, String name, String model, Long type_id, Long unit_id, String location, String description) {
            this.id = id;
            this.name = name;
            this.model = model;
            this.type_id = type_id;
            this.unit_id = unit_id;
            this.location = location;
            Description = description;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public Integer getRangeFrom() {
            return rangeFrom;
        }

        public void setRangeFrom(Integer rangeFrom) {
            this.rangeFrom = rangeFrom;
        }

        public Integer getRangeTo() {
            return rangeTo;
        }

        public void setRangeTo(Integer rangeTo) {
            this.rangeTo = rangeTo;
        }

        public Long getType_id() {
            return type_id;
        }

        public void setType_id(Long type_id) {
            this.type_id = type_id;
        }

        public Long getUnit_id() {
            return unit_id;
        }

        public void setUnit_id(Long unit_id) {
            this.unit_id = unit_id;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String description) {
            Description = description;
        }
    }

}
