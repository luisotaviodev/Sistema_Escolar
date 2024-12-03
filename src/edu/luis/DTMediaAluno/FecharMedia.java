package edu.luis.DTMediaAluno;

import java.util.ArrayList;

import edu.luis.DTPesquisa.PesquisarAlunoBD;
import edu.luis.Utils.Mensagem;

public class FecharMedia {
    Mensagem oDTUtilMensagem                 = new Mensagem();
    PesquisarAlunoBD oPesquisarAluno         = new PesquisarAlunoBD();
    ArrayList<Float> aNotas                  = new ArrayList<>();
    InserirMediaAlunoBD oInserirMediaAlunoBD = new InserirMediaAlunoBD();
    public static final float MEDIA = 5.0f;

    public void SelecionarAluno(){
        Boolean lConfirmarDados = false;
        while (!lConfirmarDados) {
          System.out.println(oPesquisarAluno.PesquisarAluno());
          Integer iCodAluno    = oDTUtilMensagem.IntScannerAndPrint("Por favor Digite o Código do Aluno que deseja fechar a média: ");    
          Integer iBimestre    = oDTUtilMensagem.IntScannerAndPrint("Por favor Digite o Bimestre que está realizando o fechamento da média: ");
          Float nNotaAluno     = FecharMediaAluno();
          String cStatusAluno  = nNotaAluno > MEDIA ? "A" : "R";   
          String cMateria      = oDTUtilMensagem.StrScannerAndPrint("Por favor Digite a Matéria que Deseja fechar a média:");

          lConfirmarDados = "SIM".equalsIgnoreCase(oDTUtilMensagem.StrScannerAndPrint("Os dados estão corretos? Digite (SIM) ou (NAO)"));

          if (lConfirmarDados) {
            oInserirMediaAlunoBD.InserirMediaAluno(iBimestre, iCodAluno, cStatusAluno, nNotaAluno, cMateria, oPesquisarAluno.PesquisarNomeAluno(iCodAluno));  
          }
         }
    }

    public float FecharMediaAluno(){
        Integer iQtdProva = 0;
        iQtdProva = oDTUtilMensagem.IntScannerAndPrint("Por favor Digite a Quantidade de Provas Realizadas este Bimestre: ");

        for (int i = 1; i <= iQtdProva; i++) {
            aNotas.add(oDTUtilMensagem.FloatScannerAndPrint("Nota Prova " + i + ":"));
        }

        return Float.parseFloat(String.format("%.2f", CalcularMedia(aNotas)).replace(",", "."));
    }

    public float CalcularMedia(ArrayList<Float> nNotas){
        float nSoma = 0;

        for (float nNota : nNotas) {
          nSoma += nNota;     
        }
        return nSoma/nNotas.size();
    }
}
