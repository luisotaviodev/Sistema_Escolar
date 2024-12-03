package edu.luis.DTConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastrarProfBD {
    public void RealizarCadastroProfessor(String cNome, Integer iIdade, String cDataNascimento, String cEndereco, String cTelefone,
                                      String cEmail, String cGenero, String cMateria, String cObservacao){

        ConexaoBD oConexaoBD = new ConexaoBD();

        String cSQL = "INSERT INTO alunos (nome            " +
        "                                 ,idade           " +
        "                                 ,data_nascimento " +
        "                                 ,endereco        " +
        "                                 ,telefone        " +
        "                                 ,email           " +
        "                                 ,genero          " +
        "                                 ,materia         " +
        "                                 ,observacoes)    " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);         " ;

        try (Connection        conn  = oConexaoBD.connect();
             PreparedStatement pstmt = conn.prepareStatement(cSQL) ){
                pstmt.setString(1,  cNome);
                pstmt.setInt(2,  iIdade);
                java.sql.Date DataNascimento = java.sql.Date.valueOf(cDataNascimento); 
                pstmt.setDate(3, DataNascimento);  
                pstmt.setString(4,  cEndereco);
                pstmt.setString(5,  cTelefone);
                pstmt.setString(6,  cEmail);
                pstmt.setString(7,  cGenero);
                pstmt.setString(8,  cMateria);
                pstmt.setString(9,  cObservacao);

                int rowsInserted = pstmt.executeUpdate();
                System.out.println( rowsInserted > 0  ? "Novo Professor cadastrado com sucesso!" : "Nenhum Professor cadastrado!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Professor: " + e.getMessage());    
        }

    }
    
}