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
        String sql = "INSERT INTO financeiro (idFinanceiro, idImovelFinanceiro, situacaoFinanceiro, valorParcela, "
                + "comimobiliariafinanceiro, iptu, condominio, energia, agua, lixo, gas, outros, abono, valor_total, Locatario) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            if (this.conexao.conectar()) {
                Connection conn = this.conexao.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);

                statement.setInt(1, cadastroContrato.getIdFinanceiro());
                statement.setInt(2, cadastroContrato.getIdImovelFinanceiro());
                statement.setString(3, cadastroContrato.getSituacaoFinanceiro());
                statement.setString(4, cadastroContrato.getValorParcela());
                statement.setString(5, cadastroContrato.getComimobiliariafinanceiro());
                statement.setString(6, cadastroContrato.getIptu());
                statement.setString(7, cadastroContrato.getCondominio());
                statement.setString(8, cadastroContrato.getEnergia());
                statement.setString(9, cadastroContrato.getAgua());
                statement.setString(10, cadastroContrato.getLixo());
                statement.setString(11, cadastroContrato.getGas());
                statement.setString(12, cadastroContrato.getOutros());
                statement.setString(13, cadastroContrato.getAbono());
                statement.setString(14, cadastroContrato.getValor_total());
                statement.setInt(15, cadastroContrato.getLocatario());

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

                    financeiro.setIdFinanceiro(resultado.getInt("idFinanceiro"));
                    financeiro.setIdImovelFinanceiro(resultado.getInt("idImovelFinanceiro"));
                    financeiro.setSituacaoFinanceiro(resultado.getString("situacaoFinanceiro"));
                    financeiro.setValorParcela(resultado.getString("valorParcela"));
                    financeiro.setComimobiliariafinanceiro(resultado.getString("comimobiliariafinanceiro"));
                    financeiro.setIptu(resultado.getString("iptu"));
                    financeiro.setCondominio(resultado.getString("condominio"));
                    financeiro.setEnergia(resultado.getString("energia"));
                    financeiro.setAgua(resultado.getString("agua"));
                    financeiro.setLixo(resultado.getString("lixo"));
                    financeiro.setGas(resultado.getString("gas"));
                    financeiro.setOutros(resultado.getString("outros"));
                    financeiro.setAbono(resultado.getString("abono"));
                    financeiro.setValor_total(resultado.getString("valor_total"));
                    financeiro.setLocatario(resultado.getInt("Locatario"));

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
