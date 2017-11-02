package com.januszwisniowski.scratch.springboot.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class TestDTO {

    private ZonedDateTime dateTimeField;

    private String stringField;
}
