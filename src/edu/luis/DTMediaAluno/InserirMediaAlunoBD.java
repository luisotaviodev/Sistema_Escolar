package edu.luis.DTMediaAluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.luis.DTConexao.ConexaoBD;

public class InserirMediaAlunoBD {
    ConexaoBD oConexaoBD = new ConexaoBD();
      public void InserirMediaAluno(Integer iBimestre, Integer iCodAluno, String cStatusAluno, Float nNota, String cMateria, String cNomeAluno){

        String cSQL = "INSERT INTO notafinal (bimestre         " +
        "                                    ,aluno_id         " +
        "                                    ,status_aluno     " +
        "                                    ,nota             " +
        "                                    ,materia_escolar) " +
        "                   VALUES (?, ?, ?, ?, ?);            " ;

        try (Connection        conn  = oConexaoBD.connect();
             PreparedStatement pstmt = conn.prepareStatement(cSQL) ){
                pstmt.setInt(1,  iBimestre);
                pstmt.setInt(2,  iCodAluno);
                pstmt.setString(3,  cStatusAluno);
                pstmt.setFloat(4,  nNota);
                pstmt.setString(5,  cMateria);

                int rowsInserted = pstmt.executeUpdate();
                System.out.println(rowsInserted > 0 
                                  ? String.format("Media do Aluno: %s Cadastrada com Sucesso!", cNomeAluno)
                                  : String.format("Não foi possível fechar a Media do Aluno: %s.", cNomeAluno));

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Professor: " + e.getMessage());    
        }

      }
        
}
