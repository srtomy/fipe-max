package com.tarcisio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tarcisio.services.ModeloService;

import org.junit.jupiter.api.Test;

public class ModeloServiceTest{


    @Test
    void deveCarregarModeloPorId(){
        ModeloService service = new ModeloService();


        String idMarca = "6";
        String idModelo = "43";

        String atual = service.findByModeloId(idModelo, idMarca);

        boolean esperado = atual.contains("100 2.8 V6");

        

        assertEquals(true, esperado);

    }

}