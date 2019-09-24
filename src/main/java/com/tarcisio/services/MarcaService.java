package com.tarcisio.services;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class MarcaService {
    File jsonData = new File("marcas.json");

    public String findAll(){
        try {
            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            //read JSON like DOM Parser
            JsonNode rootNode = objectMapper.readTree(jsonData);
            return  rootNode.toString();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
