package com.tarcisio.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.tarcisio.services.exception.ObjectNotFoundException;

import java.io.File;
import java.util.Iterator;

public class ModeloService {

    File jsonData = new File("modelos.json");

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

    public String findByModeloId(String idModelo, String idMarca) {
        // create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();        

        try {
            // read JSON like DOM Parser
            JsonNode rootNode = objectMapper.readTree(jsonData);
            Iterator<JsonNode> elements = rootNode.elements();
            while (elements.hasNext()) {
                JsonNode node = elements.next();

                String idModelo_ = node.get("id").asText();
                String strIdMarca = node.get("id_marca").asText();


                if (idModelo_.equals(idModelo)&&strIdMarca.equals(strIdMarca)) {
                   return node.toString();
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("erro ao carregar json: " + jsonData.getName(), ex);
        }   
        
        return null;
    }

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
