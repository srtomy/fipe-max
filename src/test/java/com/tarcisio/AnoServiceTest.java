package com.tarcisio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import com.tarcisio.services.AnoService;

import org.junit.jupiter.api.Test;

public class AnoServiceTest {

        @Test
        public void deveCarregarAno() {
                AnoService service = new AnoService();
                
                String idModelo = "43";

                service.findById(idModelo);

                fail();

        }

}
