/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.januszwisniowski.scratch.springboot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("scratch")
public class ValidationTestControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mvc;

    @Test
    public void testBrokenValidationDate() throws Exception {
        this.mvc
            .perform(
                post("/test/broken-validation")
                    .content("{ \"date\": \"\", \"time\": \"\", \"age\": \"12\" }")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON_UTF8)
            )
            .andExpect(status().isBadRequest());
    }

    @Test
    public void testDtoFromRequestPrams() throws Exception {
        MvcResult mvcResult = this.mvc
            .perform(
                get("/test/dto-from-request-params")
                    .param("aDateTime", "2012-11-01T12:10:11.123Z")
                    .param("aField", "a value")
                    .accept(MediaType.APPLICATION_JSON_UTF8)
            )
            // .andExpect(status().isOk())
            // .andExpect(jsonPath("$.aDateTime").value("2012-11-01T12:10:11.123Z"))
            // .andExpect(jsonPath("$.aField").value("a value"))
            .andReturn();
    }
}


