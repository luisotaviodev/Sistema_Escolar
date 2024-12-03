package edu.luis.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Conversao {
    public String DateToStr(String cData) {
        try {
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date dataParseada = formatoEntrada.parse(cData);
            SimpleDateFormat formatoSaida = new SimpleDateFormat("yyyy-MM-dd");
            
            return formatoSaida.format(dataParseada);
        } catch (ParseException e) {
            System.out.println("Erro ao converter a data: " + e.getMessage());
            return null;
        }
    }
}
