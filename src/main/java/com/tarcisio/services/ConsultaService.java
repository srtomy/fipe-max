package com.tarcisio.services;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tarcisio.domain.Consulta;
import com.tarcisio.repository.ConsultaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repo;

    public List<Consulta> findAll() {
        return repo.findAll();
    }

    public Consulta insert(String str, String ip) {
        Consulta c = toConsulta(str);       
        c.setIp(ip);
        c.setData(LocalDateTime.now());

        c.setId(null);
        return repo.save(c);       
    }

    Consulta toConsulta(String str) {
        ModeloService mService = new ModeloService();
        AnoService aService = new AnoService();

        // create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();        

        try {
            // read JSON like DOM Parser
            JsonNode rootNode = objectMapper.readTree(str);
            Iterator<JsonNode> elements = rootNode.elements();
            while (elements.hasNext()) {
                JsonNode node = elements.next();

                //consulta nome da marca
                String idMarString = node.get("id_marca").asText();
        
                String idModelo = node.get("id_modelo").asText();
                JsonNode nodeModelo = new ObjectMapper().readTree( mService.findByModeloId(idModelo,idMarString));

                String idAno = node.get("id_ano").asText();                
                JsonNode nodeAno = new ObjectMapper().readTree(aService.findByIdAno(idAno,idModelo));



                String marca = node.get("marca").asText();
                String valor = node.get("preco").asText();
                String modelo = nodeModelo.get("name").asText();                
                String ano =nodeAno.get("name").asText();

                Consulta c = new Consulta();
                c.setAno(ano);
                c.setMarca(marca);
                c.setValor(valor);
                c.setModelo(modelo);                

                return c;

            }
        } catch (Exception ex) {
            throw new RuntimeException("erro ao carregar json: ");
        }
        return null;
    }

}