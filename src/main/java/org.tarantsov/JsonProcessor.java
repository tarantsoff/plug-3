package org.tarantsov;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class JsonProcessor {
    private final ObjectMapper objectMapper;

    public JsonProcessor() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    public String processJson(String jsonString, String jsonPath) throws IOException {
        JsonNode jsonNode = objectMapper.readTree(jsonString);
        JsonNode nestedJsonNode = jsonNode.at(jsonPath);
        return objectMapper.writeValueAsString(nestedJsonNode);
    }

    public void removeNodes() throws JsonProcessingException {
        String jsonString = "{\"name\": \"John\", \"age\": 30, \"ltrskmrf\": \"value1\", \"depksd\": \"value2\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonString);

        if (rootNode instanceof ObjectNode) {
            ObjectNode objectNode = (ObjectNode) rootNode;
            objectNode.remove("ltrskmrf");
            objectNode.remove("depksd");
        }

        String modifiedJsonString = objectMapper.writeValueAsString(rootNode);
        System.out.println(modifiedJsonString);

    }
}

