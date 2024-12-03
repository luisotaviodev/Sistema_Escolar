package edu.luis.Operacoes;

import edu.luis.DTCadastro.*;
import edu.luis.DTMediaAluno.FecharMedia;
import edu.luis.Utils.Mensagem;

public class MenuOperacoes {
    public void OperacoesMenu() {
        Mensagem oMensagem = new Mensagem();
        CadastrarAluno oRealizaCadastroAluno = new CadastrarAluno();
        CadastrarProf  oRealizarCadastroProf = new CadastrarProf();
        FecharMedia oFecharMedia             = new FecharMedia();
        Integer iOperacao;

        System.out.println("Bem vindo à melhor Instituição de Ensino, Ensino Plus.");
        System.out.println("Por favor, informe o número da Operação que deseja realizar");
        System.out.println("1- Cadastrar Aluno\n2- Cadastrar Professor\n3- Fechar Média dos Alunos");
        iOperacao = oMensagem.IntScannerAndPrint("Digite a operação:");      
        switch (iOperacao) {
            case 1:
                oRealizaCadastroAluno.RealizarCadastroAluno();
                break;
            case 2:
                oRealizarCadastroProf.RealizarCadastroProfessor();
                break;
            case 3:
                oFecharMedia.SelecionarAluno(); 
                break;
            default:
                System.out.println("");
        }
        
    }
}
