package org.tarantsov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonProcessorTest {
    private JsonProcessor jsonProcessor;

    @BeforeEach
    public void setUp() {
        jsonProcessor = new JsonProcessor();
    }

    @Test
    public void testProcessJson() throws IOException {
        String jsonString = Files.readString(Path.of("src/test/resources/test_json.txt"));
        String jsonPath = "/a/b/c";
        String expectedFormattedJson = "{\n  \"d\" : \"text\"\n}";
        String actualFormattedJson = jsonProcessor.processJson(jsonString, jsonPath);
        assertEquals(expectedFormattedJson, actualFormattedJson);
    }
}
