package com.januszwisniowski.scratch.springboot.controller.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;

public class PersonForm {
    @NotBlank
    private String date;

    @NotBlank
    private String time;

    @Min(0)
    private int age;

    public String getDateTime() {
        return date + "T" + time;
    }

    public int getAge() { return age; }
}
