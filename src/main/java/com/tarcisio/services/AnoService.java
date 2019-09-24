package com.tarcisio.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.tarcisio.repository.Repository;

import java.io.File;
import java.util.Iterator;

public class AnoService implements Repository {

    File jsonData = new File("anos.json");


    @Override
    public String findById(String idModelo) {
        try {
            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode root = objectMapper.createArrayNode();

            //read JSON like DOM Parser
            JsonNode rootNode = objectMapper.readTree(jsonData);
            Iterator<JsonNode> elements = rootNode.elements();
            while (elements.hasNext()) {
                JsonNode node = elements.next();

                String idModelo_ = node.get("id_modelo").toString();
                if(idModelo_.equals(idModelo)) {
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

            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            //read JSON like DOM Parser
            JsonNode rootNode = objectMapper.readTree(jsonData);            
           
            return rootNode.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
