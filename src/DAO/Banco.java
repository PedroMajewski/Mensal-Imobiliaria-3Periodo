package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Banco {
    
    private String servidor;
    private String banco;
    private String usuario;
    private String senha;
    private Connection conexao;
    
    public Banco() {
        this.servidor = "200.195.171.124";
        this.banco = "grupo07_imobiliaria"; 
        this.usuario = "grupo07";
        this.senha = "Vu9EIaowZuJ3mBsP"; 
    }

    public boolean conectar() {
        try {
            this.conexao = DriverManager.getConnection("jdbc:mysql://" + this.servidor + "/" + this.banco, this.usuario, this.senha);
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na conexão: " + ex.getMessage(), ex);
        }
    }

    public void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close(); 
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
            }
        }
    }

    public boolean validarUsuario(String usuario, String senha) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND senha = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); 
        } catch (SQLException ex) {
            System.out.println("Erro ao validar usuário: " + ex.getMessage());
            return false;
        }
    }
}
