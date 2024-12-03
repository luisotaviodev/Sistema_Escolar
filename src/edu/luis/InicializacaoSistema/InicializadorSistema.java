package edu.luis.InicializacaoSistema;

import edu.luis.DTConexao.TabelasBD;

public class InicializadorSistema {

    public void CriarTabelas() {
      TabelasBD oTabelas = new TabelasBD();
      oTabelas.CriarTabelaAlunos();    
      oTabelas.CriarTabelaNotaFinal();
    }    
}
