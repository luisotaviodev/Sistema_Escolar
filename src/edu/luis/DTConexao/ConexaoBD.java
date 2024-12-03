package edu.luis.DTConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private final String url = "jdbc:postgresql://localhost:5432/EnsinoPlus?useUnicode=true&characterEncoding=UTF-8";
    private final String user = "postgres";
    private final String password = "123";

    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver"); // Registrar o driver manualmente
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC do PostgreSQL não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao PostgreSQL: " + e.getMessage());
        }
        return conn;
    }   
}
