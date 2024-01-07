package task.agsrTest.dto;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TypeDto {


    @JsonProperty("type")
    private String name;

    public TypeDto() {
    }

    public TypeDto( String name) {
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
        return "TypeDto{" +
                "name='" + name + '\'' +
                '}';
    }
}