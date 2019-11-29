package com.tarcisio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tarcisio.services.AnoService;

import org.junit.jupiter.api.Test;

public class AnoServiceTest {

        @Test
        public void deveCarregarAnoPorId() {
                AnoService service = new AnoService();
                
                String idAno = "1995-1";
                String idModelo = "43";

                String atual =  service.findByIdAno(idAno, idModelo);

                boolean contains = atual.contains("100 2.8 V6");

                assertEquals(contains, true);
        }       

}
