package com.tarcisio.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class ObterAllValuesJson {

    public String obterMarcas(File file) throws IOException {
        return  new String(Files.readAllBytes(Paths.get("marcas.json")));
    }

    public String obterModelo(URL urlModelo) throws IOException {
        String allModelo = "";
        URLConnection conn = urlModelo.openConnection();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            allModelo = reader.lines().collect(Collectors.joining("\n"));
        }
        return allModelo;
    }

    public String obterAno(URL urlAno) throws IOException {
        String allAno = "";
        URLConnection conn = urlAno.openConnection();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            allAno = reader.lines().collect(Collectors.joining("\n"));
        }
        return allAno;
    }

    public String obterValor(URL urlmarcaModeloAno) throws IOException {
        String allAno = "";
        URLConnection conn = urlmarcaModeloAno.openConnection();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            allAno = reader.lines().collect(Collectors.joining("\n"));
        }
        return allAno;
    }
}
