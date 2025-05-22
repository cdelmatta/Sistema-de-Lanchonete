package bancoDados;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Conexao instancia;
    private Connection conexao;

    private static final String URL = "jdbc:postgresql://localhost:5432/bancoprova";
    private static final String USUARIO = "user";
    private static final String SENHA = "password";

    public Conexao() {
        try {
            Class.forName("org.postgressql.Driver");
            this.conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            this.conexao.setAutoCommit(true);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro na conexao: " + e.getMessage());
        }
    }

    public static synchronized Conexao getIntancia() {
        if (instancia == null) {
            instancia = new Conexao();
        }
        return instancia;
    }

    public static Connection getConexao() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão com o banco de dados", e);
        }
    }

    private void reconectar() {
        try {
            this.conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            this.conexao.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao reconectar ao banco de dados", e);
        }
    }

    public void fecharConexao() {
        try {
            if (this.conexao != null && !this.conexao.isClosed()) {
                this.conexao.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar conexao: " + e.getMessage());
        }
    }
}
