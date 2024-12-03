package edu.luis.DTConexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TabelasBD {
    ConexaoBD oConexao = new ConexaoBD();
    String cSQL = "";
    public void CriarTabelaAlunos() {

        cSQL = "CREATE TABLE IF NOT EXISTS alunos (                          "+
              " cod_aluno SERIAL PRIMARY KEY                                 "+
              ",nome VARCHAR(100) NOT NULL                                   "+
              ",idade INTEGER NOT NULL                                       "+
              ",data_nascimento DATE NOT NULL                                "+
              ",endereco VARCHAR(120) NOT NULL                               "+
              ",telefone VARCHAR(15)                                         "+
              ",email VARCHAR(100) NOT NULL                                  "+
              ",genero CHAR(1) CHECK (genero IN ('M', 'F', 'O'))             "+
              ",classe VARCHAR(15) NOT NULL                                  "+
              ",status_aluno CHAR(1) CHECK (status_aluno IN('A', 'RP', 'R')) "+
              ",observacoes TEXT);                                           ";

        try (Connection conn = oConexao.connect(); 
             Statement stmt = conn.createStatement()) {
            
            stmt.execute(cSQL);
            System.out.println("Tabela ''Alunos'' criada com sucesso.");
            cSQL = "COMMENT ON COLUMN alunos.status_aluno IS 'A = Aprovado, RP = Reprovado, R = Recuperacao';";
            stmt.execute(cSQL);
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
        }
    } 
    
    public void CriarTabelaNotaFinal(){
        cSQL = "CREATE TABLE IF NOT EXISTS NotaFinal                          (" +
               "  id SERIAL PRIMARY KEY                                        " +
               " ,bimestre INTEGER NOT NULL                                    " +
               " ,aluno_id INTEGER NOT NULL                                    " +
               " ,status_aluno CHAR(1) CHECK (status_aluno IN('A', 'R')) " +
               " ,nota DECIMAL(5,2) NOT NULL                                   " +
               " ,materia_escolar VARCHAR(75) NOT NULL                         " +
               " ,FOREIGN KEY (aluno_id) REFERENCES alunos(cod_aluno));        ";

        try (Connection conn = oConexao.connect();
             Statement  stmt = conn.createStatement()){

            stmt.execute(cSQL);
            System.out.println("Tabela ''Nota Final'' criada com sucesso.");   
            cSQL = "COMMENT ON COLUMN NotaFinal.status_aluno IS 'A = Aprovado, R = Recuperacao';";
            stmt.execute(cSQL);
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());    
        }
    }  
}
