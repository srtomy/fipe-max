package com.tarcisio.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.tarcisio.repository.Repository;

import java.io.File;
import java.util.Iterator;

public class ModeloService implements Repository {

    File jsonData = new File("modelos.json");



    @Override
    public String findById(int idMarca) {
        try {

            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode root = objectMapper.createArrayNode();

            //read JSON like DOM Parser
            JsonNode rootNode = objectMapper.readTree(jsonData);
            Iterator<JsonNode> elements = rootNode.elements();
            while (elements.hasNext()) {
                JsonNode node = elements.next();
                int idMarca_ = node.get("id_marca").asInt();
                if(idMarca_ == (idMarca)) {
                    root.add(node);

                }
            }
            return root.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String findAll() {
        try {
            StringBuilder builder = new StringBuilder();

            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            //read JSON like DOM Parser
            JsonNode rootNode = objectMapper.readTree(jsonData);
            Iterator<JsonNode> elements = rootNode.elements();
            while (elements.hasNext()) {
                JsonNode node = elements.next();
                builder.append(node.toString());
            }
            return builder.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
