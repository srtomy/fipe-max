package com.tarcisio.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObterIds {

    public List<String> obterIdAno(String jsonModeloMarca) throws IOException {
        List<String> ids = new ArrayList<>();

        //read json file data to String
        byte[] jsonData = jsonModeloMarca.getBytes();

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //read JSON like DOM Parser
        JsonNode rootNode = objectMapper.readTree(jsonData);
        Iterator<JsonNode> elements = rootNode.elements();
        while(elements.hasNext()){
            ids.add(elements.next().get("id").toString().replaceAll("\"", ""));
        }
        return ids;
    }

    public List<String> obterIdModelo(String jsonMarca) throws IOException {
        List<String> ids = new ArrayList<>();

        //read json file data to String
        byte[] jsonData = jsonMarca.getBytes();

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //read JSON like DOM Parser
        JsonNode rootNode = objectMapper.readTree(jsonData);
        Iterator<JsonNode> elements = rootNode.elements();
        while(elements.hasNext()){
            ids.add(elements.next().get("id").toString().replaceAll("\"", ""));
        }
        return ids;
    }

    public List<String> ObterIdMarcas(String jsonAllMarcas) throws IOException {
        List<String> ids = new ArrayList<>();

        //read json file data to String
        byte[] jsonData = jsonAllMarcas.getBytes();

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //read JSON like DOM Parser
        JsonNode rootNode = objectMapper.readTree(jsonData);
        Iterator<JsonNode> elements = rootNode.elements();
        while(elements.hasNext()){
            ids.add(elements.next().get("id").toString());
        }
        return ids;
    }

    public List<String> ObterIdValor(String jsonValor) throws IOException {
        List<String> ids = new ArrayList<>();

        //read json file data to String
        byte[] jsonData = jsonValor.getBytes();

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //read JSON like DOM Parser
        JsonNode rootNode = objectMapper.readTree(jsonData);
        Iterator<JsonNode> elements = rootNode.elements();
        while(elements.hasNext()){
            ids.add(elements.next().get("id").toString().replaceAll("\"", ""));
        }
        return ids;
    }
}
