package edu.luis.DTCadastro;

import edu.luis.DTConexao.CadastrarAlunoBD;
import edu.luis.Utils.Conversao;
import edu.luis.Utils.Mensagem;

public class CadastrarAluno {
    public void RealizarCadastroAluno(){
        CadastrarAlunoBD oCadAluno = new CadastrarAlunoBD();
        Conversao oConversao = new Conversao();
        Mensagem oDTUtilMensagem = new Mensagem();
        String cNome; 
        Integer iIdade;
        String cDataNascimento ; 
        String cEndereco; 
        String cTelefone;
        String cEmail; 
        String cGenero; 
        String cClasse; 
        String cObservacao;

       
      System.out.println("Digite os Dados do Aluno: ");
      cNome           = oDTUtilMensagem.StrScannerAndPrint("Nome Completo: ");
      iIdade          = oDTUtilMensagem.IntScannerAndPrint("Idade: ");
      cDataNascimento = oDTUtilMensagem.StrScannerAndPrint("Data Nascimento: ");
      cEndereco       = oDTUtilMensagem.StrScannerAndPrint("Endereço: ");
      cTelefone       = oDTUtilMensagem.StrScannerAndPrint("Telefone: ");
      cEmail          = oDTUtilMensagem.StrScannerAndPrint("Email: ");
      cGenero         = oDTUtilMensagem.StrScannerAndPrint("Gênero (M, F, O): ");
      cClasse         = oDTUtilMensagem.StrScannerAndPrint("Classe: ");
      cObservacao     = oDTUtilMensagem.StrScannerAndPrint("Observação: "); 

      oDTUtilMensagem.closeScanner();
      oCadAluno.RealizarCadastroAluno(cNome, iIdade, oConversao.DateToStr(cDataNascimento), cEndereco, cTelefone, cEmail, cGenero, cClasse, cObservacao);
    }  
}
