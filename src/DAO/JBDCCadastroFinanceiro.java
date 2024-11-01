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
                + "numeroParcelas, valor_total, locatario, locador) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
                statement.setString(7, cadastroContrato.getLocatario());
                statement.setString(8, cadastroContrato.getLocador());

                statement.execute();
                statement.close();
                conn.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
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
                    financeiro.setLocatario(resultado.getString("Locatario"));
                    financeiro.setLocatario(resultado.getString("Locador"));

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
}
