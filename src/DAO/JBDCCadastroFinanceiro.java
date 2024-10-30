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
    
    public JBDCCadastroFinanceiro(){
        this.conexao = new JBDCConnect();
    }
}
