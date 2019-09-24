package com.tarcisio.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.tarcisio.repository.Repository;
import com.tarcisio.services.exception.ObjectNotFoundException;

import java.io.File;
import java.util.Iterator;

public class ModeloService implements Repository {

    File jsonData = new File("modelos.json");

    @Override
    public String findById(String idMarca) {

        // create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode root = objectMapper.createArrayNode();

        try {
            // read JSON like DOM Parser
            JsonNode rootNode = objectMapper.readTree(jsonData);
            Iterator<JsonNode> elements = rootNode.elements();
            while (elements.hasNext()) {
                JsonNode node = elements.next();
                String idMarca_ = node.get("id_marca").toString();
                if (idMarca_.equals(idMarca)) {
                    root.add(node);
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("erro ao carregar json: " + jsonData.getName(), ex);
        }

        if (root.size() == 0) {
            throw new ObjectNotFoundException("marca não encontrada: " + idMarca);
        }

        return root.toString();
    }

    @Override
    public String findAll() {
        try {
            StringBuilder builder = new StringBuilder();

            // create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // read JSON like DOM Parser
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
