package week3.restimpl.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentDTO {
    private String name;

    public StudentDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
