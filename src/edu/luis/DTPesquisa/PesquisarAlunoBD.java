package edu.luis.DTPesquisa;

import edu.luis.DTConexao.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PesquisarAlunoBD {
    ConexaoBD oConexaoBD = new ConexaoBD();
    String cSQL = "";
    StringBuilder cbResultado = new StringBuilder();

    public String PesquisarAluno(){
        cbResultado.setLength(0);
        cSQL = "SELECT cod_aluno, nome from alunos";
        try (Connection        conn  = oConexaoBD.connect();
             PreparedStatement pstmt = conn.prepareStatement(cSQL); 
             ResultSet            rs = pstmt.executeQuery()){

                while (rs.next()) {
                int codAluno = rs.getInt("cod_aluno");
                String nome = rs.getString("nome");

                cbResultado.append("Código: ").append(codAluno)
                          .append(" | Nome: ").append(nome).append("\n");
            }


        } catch (SQLException e) {
            return "Erro ao consultar alunos: " + e.getMessage();   
        }
        return cbResultado.length() > 0 ? cbResultado.toString() : "Nenhum aluno encontrado.";
    }

    public String PesquisarNomeAluno(Integer iCodAluno){
        cbResultado.setLength(0);
        cSQL = "SELECT nome from alunos WHERE cod_aluno = ?";
        try (Connection        conn  = oConexaoBD.connect();
             PreparedStatement pstmt = conn.prepareStatement(cSQL); ){

                pstmt.setInt(1, iCodAluno);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        String cNome = rs.getString("nome");
                        cbResultado.append(cNome);
                    }
                }

        } catch (SQLException e) {
            return "Erro ao consultar alunos: " + e.getMessage();   
        }
        return cbResultado.length() > 0 ? cbResultado.toString() : "Nenhum aluno encontrado."; 
    }


}