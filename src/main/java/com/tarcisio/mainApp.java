package com.tarcisio;

import com.tarcisio.services.ModeloService;

public class mainApp {

    public static void main(String[] args) {
        ModeloService service = new ModeloService();

        service.findById("7");


    }

}