package com.januszwisniowski.stackoverflow.validationdemo.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;

public class FixedPersonForm {
    @NotBlank
    @JsonProperty
    private String date;

    @NotBlank
    @JsonProperty
    private String time;

    @Min(0)
    private int age;

    public String getDateTime() {
        return date + "T" + time;
    }

    public int getAge() { return age; }
}
