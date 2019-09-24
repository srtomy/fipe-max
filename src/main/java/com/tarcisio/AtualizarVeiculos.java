package com.tarcisio;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tarcisio.logic.ObterAllValuesJson;
import com.tarcisio.logic.ObterIds;

public class AtualizarVeiculos {

    public static void main(String args[]) throws IOException, InterruptedException {
        ObterAllValuesJson obterValores = new ObterAllValuesJson();
        ObterIds obterIds = new ObterIds();

        FileWriter fwAnos = new FileWriter(new File("anos.json"), true);
        FileWriter fwModelos = new FileWriter(new File("modelos.json"), true);
        FileWriter fwValores = new FileWriter(new File("valores.json"), true);

        int pausa = 1000; //millisegundo


        URL url;


        String stringAllMarcas = obterValores.obterMarcas(new File("marcas.json"));
        List<String> idsMarcas = obterIds.ObterIdMarcas(stringAllMarcas);

        int countMarca = 1;
        for (String idMarca : idsMarcas) {

            try {
                //obter modelos
                url = new URL("http://fipeapi.appspot.com/api/1/carros/veiculos/" + idMarca + ".json");
                String stringModelo = obterValores.obterModelo(url);
                List<String> idsModelo = obterIds.obterIdModelo(stringModelo);
                fwModelos.append(stringModelo.replaceAll("\"fipe_marca\"", "\"id_marca\": " + idMarca + ", \"fipe_marca\""));
                fwModelos.flush();


                Thread.sleep(pausa);

                //obter Anos
                int countModelo = 1;
                for (String idModelo : idsModelo) {
                    url = new URL("http://fipeapi.appspot.com/api/1/carros/veiculo/" + idMarca + "/" + idModelo + ".json");
                    String stringAno = obterValores.obterAno(url);
                    List<String> idsAno = obterIds.obterIdAno(stringAno);
                    String str1 = "\"id_marca\": " + idMarca;
                    String str2 = "\"id_modelo\": " + idModelo;
                    fwAnos.append(stringAno.replaceAll("\"fipe_marca\"", str1 + ", " + str2 + ", " + "\"fipe_marca\""));
                    fwAnos.flush();

                    Thread.sleep(pausa);

                    //obter valor
                    for (String idAno : idsAno) {
                        url = new URL("http://fipeapi.appspot.com/api/1/carros/veiculo/" + idMarca + "/" + idModelo + "/" + idAno + ".json");
                        String stringValor = obterValores.obterValor(url);


                        String str3 = "\"id_ano\": " + idAno;

                        fwValores.append(stringValor.replaceAll("\"referencia\"", str1 + ", " + str2 + ", " + str3 + " , " + "\"referencia\""));
                        fwValores.flush();

                        Thread.sleep(pausa);
                    }

                    System.out.println(gerarStatus(idsMarcas.size(), countMarca, "Marca"));
                    System.out.println("----------"+gerarStatus(idsModelo.size(), countModelo, "Modelos"));
                    countModelo++;
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                break;
            }

            Thread.sleep(pausa);
            countMarca++;
        }

        fwAnos.close();
        fwModelos.close();
        fwValores.close();

    }

    private static String gerarStatus(int max, int atual, String descricao) {
        StringBuilder builder = new StringBuilder();

        float porCem = ((float)atual * 100F/ max);
        String porCemm = String.format("%.2f", porCem);

        builder.append("").append(atual).append(" de ").append(max).append(" = ").append(porCemm).append("%").append(" -> ").append(descricao);
        return builder.toString();
    }

}