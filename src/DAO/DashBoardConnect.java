package DAO;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DashBoardConnect {
    private String servidor;
    private String banco;
    private String usuario;
    private String senha;
    private Connection conexao;

    public DashBoardConnect() {
        
        this.servidor = "200.195.171.124";
        this.banco = "grupo07_imobiliaria"; 
        this.usuario = "grupo07";
        this.senha = "Vu9EIaowZuJ3mBsP"; 
    }

    public boolean conectar() {
        try {
            // Verifique se o banco de dados é selecionado corretamente na conexão
            this.conexao = DriverManager.getConnection(
                "jdbc:mysql://" + this.servidor + ":3306/" + this.banco + "?useSSL=false&serverTimezone=UTC", 
                this.usuario, 
                this.senha
            );
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na conexão: " + ex.getMessage(), ex);
        }
    }
public Map<String, Integer> buscarSituacoesImoveis() {
    String sql = "SELECT situacao_atual, COUNT(*) AS total FROM situacao_imovel GROUP BY situacao_atual";
    Map<String, Integer> dados = new HashMap<>();

    try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String situacao = rs.getString("situacao_atual");
            int total = rs.getInt("total");
            dados.put(situacao, total); // Adiciona a situação e a contagem ao mapa
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        System.out.println("Erro ao buscar dados das situações dos imóveis: " + ex.getMessage());
    }

    // Debugging para imprimir os dados e garantir que está correto
    System.out.println("Dados de situação dos imóveis:");
    for (Map.Entry<String, Integer> entry : dados.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    return dados;
}
    // Método que busca os dados dos imóveis
    public Map<String, Integer> buscarDadosImoveis() {
        // Alterei para especificar o banco e a tabela
        String sql = "SELECT bairro_imovel, COUNT(*) AS total FROM grupo07_imobiliaria.imovel GROUP BY bairro_imovel"; 
        Map<String, Integer> dados = new HashMap<>();
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String bairro = rs.getString("bairro_imovel");
                int total = rs.getInt("total");
                dados.put(bairro, total);  // Armazena o bairro e a contagem no mapa
            }
        } catch (SQLException ex) {
            // Imprime o erro completo com detalhes
            ex.printStackTrace();
            System.out.println("Erro ao buscar dados dos imóveis: " + ex.getMessage());
        }
        return dados;
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
}
