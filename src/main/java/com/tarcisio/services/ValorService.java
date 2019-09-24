package com.tarcisio.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.tarcisio.services.exception.ObjectNotFoundException;

import java.io.File;
import java.util.Iterator;

public class ValorService {

    File jsonData = new File("valores.json");
    
    public String findById(String idAno, String idModelo) {

        // create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode root = objectMapper.createArrayNode();

        try {
            // read JSON like DOM Parser
            JsonNode rootNode = objectMapper.readTree(jsonData);
            Iterator<JsonNode> elements = rootNode.elements();
            while (elements.hasNext()) {
                JsonNode node = elements.next();

                String idAno_ = node.get("id_ano").asText();
                String idModelo_ = node.get("id_modelo").asText();
                if (idAno.equalsIgnoreCase(idAno_) && idModelo.equalsIgnoreCase(idModelo_)) {
                    root.add(node);
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("erro ao carregar json: " + jsonData.getName(), ex);
        }

        if (root.size() == 0)
            throw new ObjectNotFoundException("ano não encontrado: " + idAno);

        return root.toString();
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
