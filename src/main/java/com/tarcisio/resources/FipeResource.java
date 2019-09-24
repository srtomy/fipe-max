package com.tarcisio.resources;

import com.tarcisio.services.AnoService;
import com.tarcisio.services.MarcaService;
import com.tarcisio.services.ModeloService;
import com.tarcisio.services.ValorService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "ws")
public class FipeResource {

    MarcaService serviceMarca = new MarcaService();
    ModeloService serviceModelo = new ModeloService();
    AnoService serviceAno = new AnoService();    
    ValorService serviceValor = new ValorService();

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/marcas")
    public String findAllMarca(){
        return serviceMarca.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/{idMarca}")
    public String findModeloByMarca(@PathVariable String idMarca){
        return serviceModelo.findById(idMarca);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/{idMarca}/{idModelo}")
    public String findAnoByModelo(@PathVariable String idMarca, @PathVariable String idModelo){
        return serviceAno.findById(idModelo);
    }    

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/{idMarca}/{idModelo}/{idAno}")
    public String findValorByAno(@PathVariable String idMarca, @PathVariable String idModelo, @PathVariable String idAno){
        System.out.print(idAno);
        return serviceValor.findById(idAno);
    }
}
