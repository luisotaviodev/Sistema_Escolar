package edu.luis.DTCadastro;

import edu.luis.DTConexao.CadastrarProfBD;
import edu.luis.Utils.Conversao;
import edu.luis.Utils.Mensagem;

public class CadastrarProf {
   public void RealizarCadastroProfessor(){
        CadastrarProfBD oCadProf = new CadastrarProfBD();
        Conversao oConversao     = new Conversao();
        Mensagem oDTUtilMensagem = new Mensagem();
        String cNome; 
        Integer iIdade;
        String cDataNascimento ; 
        String cEndereco; 
        String cTelefone;
        String cEmail; 
        String cGenero; 
        String cMateria; 
        String cObservacao;

       
      System.out.println("Digite os Dados do Professor: ");
      cNome           = oDTUtilMensagem.StrScannerAndPrint("Nome Completo: "   );
      iIdade          = oDTUtilMensagem.IntScannerAndPrint("Idade: "           );
      cDataNascimento = oDTUtilMensagem.StrScannerAndPrint("Data Nascimento: " );
      cEndereco       = oDTUtilMensagem.StrScannerAndPrint("Endereço: "        );
      cTelefone       = oDTUtilMensagem.StrScannerAndPrint("Telefone: "        );
      cEmail          = oDTUtilMensagem.StrScannerAndPrint("Email: "           );
      cGenero         = oDTUtilMensagem.StrScannerAndPrint("Gênero (M, F, O): ");
      cMateria        = oDTUtilMensagem.StrScannerAndPrint("Matéria: "         );
      cObservacao     = oDTUtilMensagem.StrScannerAndPrint("Observação: "      ); 

      oDTUtilMensagem.closeScanner();
      oCadProf.RealizarCadastroProfessor(cNome, iIdade, oConversao.DateToStr(cDataNascimento), cEndereco, cTelefone, cEmail, cGenero, cMateria, cObservacao);
    } 
}
