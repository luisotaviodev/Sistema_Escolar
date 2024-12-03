package edu.luis.Utils;

import java.util.Scanner;

public class Mensagem {
    Scanner scanner = new Scanner(System.in);

    public String StrScannerAndPrint(String cMensagem){
      System.out.println(cMensagem);
      return scanner.nextLine();
    }

    public Integer IntScannerAndPrint(String cMensagem) {
        Integer iValor = null;
        boolean lValido = false;
        
        while (!lValido) {
            System.out.println(cMensagem);
            String cEntradaUser = scanner.nextLine();
            
            try {
                iValor = Integer.valueOf(cEntradaUser);
                lValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Idade inválida. Por favor, digite uma Idade valida.");
            }
        }
        return iValor;
    }

    public Float FloatScannerAndPrint(String cMensagem) {
        Float fValor = null;
        boolean lValido = false;

        while (!lValido) {
            System.out.println(cMensagem);
            String cEntradaUser = scanner.nextLine();

            try {
                fValor = Float.valueOf(cEntradaUser);
                lValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Por favor, digite um número decimal válido.");
            }
        }
        return fValor;
    }
    
    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

}