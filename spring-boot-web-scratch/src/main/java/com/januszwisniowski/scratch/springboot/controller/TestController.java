package com.januszwisniowski.scratch.springboot.controller;

import com.januszwisniowski.scratch.springboot.controller.dto.TestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(
        path = "dto-from-request-params",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public TestDTO dtoFromRequestParams(@Valid TestDTO testDTO) {
        return testDTO;
    }

    @PostMapping(
        path = "dto-from-request-body",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public TestDTO dtoFromRequestBody(@Valid @RequestBody TestDTO testDTO) {
        return testDTO;
    }
}
