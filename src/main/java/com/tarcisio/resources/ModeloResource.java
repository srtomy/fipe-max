package com.tarcisio.resources;

import com.tarcisio.services.ModeloService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "modelo")
public class ModeloResource {

    ModeloService service = new ModeloService();

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/{idMarca}")
    public String findById(@PathVariable int idMarca){
        return service.findById(idMarca);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/")
    public String findAll(){
        return service.findAll();
    }
}
