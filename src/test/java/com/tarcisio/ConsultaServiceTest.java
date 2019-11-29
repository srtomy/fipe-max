package com.tarcisio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tarcisio.domain.Consulta;
import com.tarcisio.services.ConsultaService;
import com.tarcisio.services.ValorService;

import org.junit.jupiter.api.Test;

public class ConsultaServiceTest{
    private ConsultaService service = new ConsultaService();

    @Test
    void deveCadastrarConsultaNoBanco(){
        ValorService vService = new ValorService();

        String idModelo = "43";
        String idAno = "1995-1";
        
        

        String jsonValor = (vService.findById(idAno, idModelo));
        Consulta c = service.insert(jsonValor, "localhost");

        String esperado = "R$ 12.476,00";

        assertEquals(esperado, c.getValor());

    }


}