package task.agsrTest.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class UnitDto {

    @JsonProperty("unit")
    private String name;

    public UnitDto() {
    }

    public UnitDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UnitDto{" +
                "name='" + name + '\'' +
                '}';
    }
}