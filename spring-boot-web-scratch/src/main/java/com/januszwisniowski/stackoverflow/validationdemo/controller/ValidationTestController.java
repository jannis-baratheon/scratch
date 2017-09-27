package com.januszwisniowski.stackoverflow.validationdemo.controller;

import com.januszwisniowski.stackoverflow.validationdemo.controller.dto.FixedPersonForm;
import com.januszwisniowski.stackoverflow.validationdemo.controller.dto.PersonForm;
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
}
