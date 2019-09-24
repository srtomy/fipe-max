package com.tarcisio.resources;

import com.tarcisio.services.MarcaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "marcas")
public class MarcaResource {

    MarcaService service = new MarcaService();

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String findAll(){
        return service.findAll();
    }
}
