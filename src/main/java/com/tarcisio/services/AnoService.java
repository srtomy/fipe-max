package com.tarcisio.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.tarcisio.services.exception.ObjectNotFoundException;

import java.io.File;
import java.util.Iterator;

public class AnoService {

    File jsonData = new File("anos.json");

    public String findById(String idModelo) {

        // create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode root = objectMapper.createArrayNode();

        try {
            // read JSON like DOM Parser
            JsonNode rootNode = objectMapper.readTree(jsonData);
            Iterator<JsonNode> elements = rootNode.elements();
            while (elements.hasNext()) {
                JsonNode node = elements.next();

                JsonNode nodeId = node.get("id_modelo");

                if (nodeId != null) {

                    if (nodeId.toString().equals(idModelo)) {
                        root.add(node);
                    }
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("erro ao carregar json: " + jsonData.getName(), ex);
        }

        if (root.size() == 0)
            throw new ObjectNotFoundException("modelo não encontrada: " + idModelo);

        return root.toString();
    }

    public String findByIdAno(String idAno, String idModelo) {

        // create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode root = objectMapper.createArrayNode();

        try {
            // read JSON like DOM Parser
            JsonNode rootNode = objectMapper.readTree(jsonData);
            Iterator<JsonNode> elements = rootNode.elements();
            while (elements.hasNext()) {
                JsonNode node = elements.next();

                JsonNode nodeId = node.get("id");
                JsonNode nodeIdModelo = node.get("id_modelo");

                if (nodeId != null) {
                    String strIdAno = nodeId.asText();
                    String strModelo = nodeIdModelo.asText();

                    if (strIdAno.equals(idAno) && strModelo.equals(idModelo)) {
                        return node.toString();
                    }
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("erro ao carregar json: " + jsonData.getName(), ex);
        }

        if (root.size() == 0)
            throw new ObjectNotFoundException("não encontrado ano id: " + idAno + ", modelo id: " + idModelo);

        return root.toString();
    }

    public String findAll() {
        try {

            // create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // read JSON like DOM Parser
            JsonNode rootNode = objectMapper.readTree(jsonData);

            return rootNode.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
