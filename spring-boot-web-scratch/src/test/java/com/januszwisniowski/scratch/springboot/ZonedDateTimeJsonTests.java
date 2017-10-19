package com.januszwisniowski.scratch.springboot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.januszwisniowski.scratch.springboot.configuration.JacksonConfiguration;
import org.assertj.core.api.ZonedDateTimeAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@AutoConfigureJsonTesters
@ContextConfiguration(classes = {JacksonConfiguration.class})
@JsonTest
public class ZonedDateTimeJsonTests {

    @Autowired
    private JacksonTester<ZonedDateTime> jsonTester;

    @Test
    public void testZonedDateTimeSerialization() throws IOException {
        // given
        String dateTimeStr = "2017-10-19T15:10:52.455Z";
        ZonedDateTime dateTime = ZonedDateTime.parse(dateTimeStr);

        // when
        JsonContent<ZonedDateTime> serializedDateTime = jsonTester.write(dateTime);

        // then
        assertThat(serializedDateTime).isEqualTo("\"" + dateTimeStr + "\"");
    }

    @Test
    public void testZonedDateTimeDeserialization() throws IOException {
        // given
        String dateTimeStr = "2017-10-19T15:10:52.455Z";

        // when
        ZonedDateTime deserializedDateTime = jsonTester.parseObject("\"" + dateTimeStr + "\"");

        // then
        assertThat(deserializedDateTime).isEqualTo(dateTimeStr);
    }
}

