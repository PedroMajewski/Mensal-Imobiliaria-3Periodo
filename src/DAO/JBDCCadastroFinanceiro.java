/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import Financeiro.CadastroFinanceiro;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import Model.FinanceiroModel;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Patryk
 */
public class JBDCCadastroFinanceiro {

    private JBDCConnect conexao;

    public JBDCCadastroFinanceiro() {
        this.conexao = new JBDCConnect();
    }

    public void inserirContratoFinanceiro(FinanceiroModel cadastroContrato) {
        String sql = "INSERT INTO financeiro (idimovel_financeiro, nomeContrato, situacao_financeiro, valor_parcela, "
                + "numeroParcelas, valor_total, locador) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            if (this.conexao.conectar()) {
                Connection conn = this.conexao.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);

                statement.setInt(1, cadastroContrato.getIdImovelFinanceiro());
                statement.setString(2, cadastroContrato.getNomeContrato());
                statement.setString(3, cadastroContrato.getSituacaoComboFinanceiro());
                statement.setString(4, cadastroContrato.getValorParcela());
                statement.setString(5, cadastroContrato.getNumeroParcelas());
                statement.setString(6, cadastroContrato.getValor_total());
                statement.setString(7, cadastroContrato.getLocador());

                statement.execute();
                statement.close();
                conn.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir contrato no banco de dados: " + ex.getMessage(), ex);
        }
    }

    public ArrayList<FinanceiroModel> ConsultarFinanceiro() {
        ArrayList<FinanceiroModel> listaFinanceiro = new ArrayList<>();
        String sql = "SELECT * FROM financeiro ORDER BY idfinanceiro";

        try {
            if (this.conexao.conectar()) {
                Connection conn = this.conexao.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);

                ResultSet resultado = statement.executeQuery();
                while (resultado.next()) {

                    FinanceiroModel financeiro = new FinanceiroModel();

                    financeiro.setIdImovelFinanceiro(resultado.getInt("idImovelFinanceiro"));
                    financeiro.setNomeContrato(resultado.getString("nomeContrato"));
                    financeiro.setSituacaoComboFinanceiro(resultado.getString("situacaoFinanceiro"));
                    financeiro.setValorParcela(resultado.getString("valorParcela"));
                    financeiro.setNumeroParcelas(resultado.getString("numeroParcelas"));
                    financeiro.setValor_total(resultado.getString("valor_total"));
                    financeiro.setLocador(resultado.getString("Locador"));

                    listaFinanceiro.add(financeiro);
                }
                statement.close();
                conn.close();
            }
            return listaFinanceiro;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public ArrayList<FinanceiroModel> filtrarImoveisPorNome(String valorPesquisa) {
        ArrayList<FinanceiroModel> listaImoveis = new ArrayList<>();

        String sql = "SELECT i.idimovel, i.nome_imovel "
                + "FROM imovel AS i "
                + "WHERE i.nome_imovel LIKE ?";

        JBDCConnect jbdcConnect = new JBDCConnect();

        try {

            if (jbdcConnect.conectar()) {

                PreparedStatement sentenca = jbdcConnect.getConnection().prepareStatement(sql);

                sentenca.setString(1, "%" + valorPesquisa + "%");

                ResultSet resultados = sentenca.executeQuery();

                while (resultados.next()) {
                    FinanceiroModel imovel = new FinanceiroModel(
                            resultados.getInt("idimovel"),
                            resultados.getString("nome_imovel")
                    );
                    listaImoveis.add(imovel);
                }

                sentenca.close();
                jbdcConnect.getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao filtrar imóveis por nome.", e);
        }

        return listaImoveis;
    }

    public ArrayList<FinanceiroModel> filtrarClientesPorNome(String valorPesquisa) {
        ArrayList<FinanceiroModel> listaImoveis = new ArrayList<>();

        String sql = "SELECT c.idcliente, c.nome_cliente "
                + "FROM cliente AS c "
                + "WHERE c.nome_cliente LIKE ?";

        JBDCConnect jbdcConnect = new JBDCConnect();

        try {

            if (jbdcConnect.conectar()) {

                PreparedStatement sentenca = jbdcConnect.getConnection().prepareStatement(sql);

                sentenca.setString(1, "%" + valorPesquisa + "%");

                ResultSet resultados = sentenca.executeQuery();

                while (resultados.next()) {
                    FinanceiroModel imovel = new FinanceiroModel(
                            resultados.getInt("idcliente"),
                            resultados.getString("nome_cliente")
                    );
                    listaImoveis.add(imovel);
                }

                sentenca.close();
                jbdcConnect.getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao filtrar imóveis por nome.", e);
        }

        return listaImoveis;
    }

    public ArrayList<FinanceiroModel> MostrarImoveisTabela() {

        ArrayList<FinanceiroModel> listaProdutos = new ArrayList<>();

        String sql = "SELECT "
                + "   i.idimovel, "
                + "   i.nome_imovel "
                + "FROM imovel i "
                + "ORDER BY i.idimovel;";

        JBDCConnect jbdcConnect = new JBDCConnect();

        try {

            if (jbdcConnect.conectar()) {

                Connection conn = jbdcConnect.getConnection();

                try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

                    while (rs.next()) {
                        FinanceiroModel produto = new FinanceiroModel();

                        produto.setIdimovel(rs.getInt("idimovel"));
                        produto.setNome_imovel(rs.getString("nome_imovel"));

                        listaProdutos.add(produto);
                    }
                }
            } else {
                System.out.println("Erro ao conectar ao banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            jbdcConnect.fecharConexao();
        }

        return listaProdutos;
    }

    public ArrayList<FinanceiroModel> MostrarClientesTabela() {

        ArrayList<FinanceiroModel> listaProdutos = new ArrayList<>();

        String sql = "SELECT "
                + "   c.idcliente, "
                + "   c.nome_cliente "
                + "FROM cliente c "
                + "ORDER BY c.idcliente;";

        JBDCConnect jbdcConnect = new JBDCConnect();

        try {

            if (jbdcConnect.conectar()) {

                Connection conn = jbdcConnect.getConnection();

                try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

                    while (rs.next()) {
                        FinanceiroModel produto = new FinanceiroModel();

                        produto.setIdimovel(rs.getInt("idcliente"));
                        produto.setNome_imovel(rs.getString("nome_cliente"));

                        listaProdutos.add(produto);
                    }
                }
            } else {
                System.out.println("Erro ao conectar ao banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            jbdcConnect.fecharConexao();
        }

        return listaProdutos;
    }

    public ArrayList<FinanceiroModel> buscarDadosTabelaFinanceiro() {
        ArrayList<FinanceiroModel> listaFinanceiro = new ArrayList<>();

        String sql = "SELECT "
                + "f.idimovel_financeiro, "
                + "f.nomeContrato, "
                + "c.nome_cliente AS nomeCliente, "
                + "f.valor_parcela, "
                + "f.numeroParcelas, "
                + "f.valor_total, "
                + "f.situacao_financeiro "
                + "FROM financeiro f "
                + "INNER JOIN cliente c ON f.locador = c.idcliente "
                + "ORDER BY f.idimovel_financeiro;";

        JBDCConnect jbdcConnect = new JBDCConnect();

        try {
            if (jbdcConnect.conectar()) {
                Connection conn = jbdcConnect.getConnection();
                try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                    while (rs.next()) {
                        FinanceiroModel financeiro = new FinanceiroModel();
                        financeiro.setIdImovelFinanceiro(rs.getInt("idimovel_financeiro"));
                        financeiro.setNomeContrato(rs.getString("nomeContrato"));
                        financeiro.setLocador(rs.getString("nomeCliente"));  // Agora pegamos o nome do cliente
                        financeiro.setValorParcela(rs.getString("valor_parcela"));
                        financeiro.setNumeroParcelas(rs.getString("numeroParcelas"));
                        financeiro.setValor_total(rs.getString("valor_total"));
                        financeiro.setSituacaoComboFinanceiro(rs.getString("situacao_financeiro"));

                        listaFinanceiro.add(financeiro);
                    }
                }
            } else {
                System.out.println("Erro ao conectar ao banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jbdcConnect.fecharConexao();
        }

        return listaFinanceiro;
    }

    public ArrayList<FinanceiroModel> filtrarContratos(String colunaSelecionada, String valorPesquisa) {
        ArrayList<FinanceiroModel> listaContratos = new ArrayList<>();

        String colunaSQL;
        switch (colunaSelecionada) {
            case "ID Imóvel":
                colunaSQL = "f.idimovel_financeiro";
                break;
            case "Nome do Contrato":
                colunaSQL = "f.nomeContrato";
                break;
            case "Nome Cliente":
                colunaSQL = "c.nome_cliente";
                break;
            case "Situação":
                colunaSQL = "f.situacao_financeiro";
                break;
            default:
                throw new IllegalArgumentException("Coluna inválida: " + colunaSelecionada);
        }

        String sql = "SELECT f.idimovel_financeiro, f.nomeContrato, c.nome_cliente, f.situacao_financeiro, "
                + "f.valor_parcela, f.numeroParcelas, f.valor_total "
                + "FROM financeiro AS f "
                + "INNER JOIN cliente AS c ON f.locador = c.idcliente "
                + "WHERE " + colunaSQL + " LIKE ?";

        JBDCConnect jbdcConnect = new JBDCConnect();
        try {
            if (jbdcConnect.conectar()) {
                PreparedStatement sentenca = jbdcConnect.getConnection().prepareStatement(sql);

                sentenca.setString(1, "%" + valorPesquisa + "%");

                ResultSet resultados = sentenca.executeQuery();

                while (resultados.next()) {
                    FinanceiroModel contrato = new FinanceiroModel(
                            resultados.getInt("idimovel_financeiro"),
                            resultados.getString("nomeContrato"),
                            resultados.getString("nome_cliente"),
                            resultados.getString("situacao_financeiro"),
                            resultados.getString("valor_parcela"),
                            resultados.getString("numeroParcelas"),
                            resultados.getString("valor_total")
                    );
                    listaContratos.add(contrato);
                }

                sentenca.close();
                jbdcConnect.getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return listaContratos;
    }

}
