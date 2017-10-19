package com.januszwisniowski.scratch.springboot.controller;

import com.januszwisniowski.scratch.springboot.controller.dto.FixedPersonForm;
import com.januszwisniowski.scratch.springboot.controller.dto.PersonForm;
import com.januszwisniowski.scratch.springboot.controller.dto.TestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
public class ValidationTestController {

    @PostMapping(
        path = "broken-validation",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public PersonForm brokenValidation(@RequestBody @Valid PersonForm personForm) {
        return personForm;
    }

    @PostMapping(
        path = "fixed-validation",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public FixedPersonForm fixedValidation(@RequestBody @Valid FixedPersonForm fixedPersonForm) {
        return fixedPersonForm;
    }

    @GetMapping(
        path = "dto-from-request-params",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public TestDTO dtoFromRequestParams(@Valid TestDTO aDto) {
        return aDto;
    }
}
