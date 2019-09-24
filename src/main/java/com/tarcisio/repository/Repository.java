package com.tarcisio.repository;

import com.fasterxml.jackson.databind.JsonNode;

public interface Repository {

   String findById(int idMarca);
    String findAll();
}
