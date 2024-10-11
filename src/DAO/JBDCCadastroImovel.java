/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import Model.CadastroImovel;
import java.sql.PreparedStatement;
import DAO.JBDCConnect;
/**
 *
 * @author pedro
 */
public class JBDCCadastroImovel {
     private JBDCConnect conexao;

    // Construtor da classe
    public JBDCCadastroImovel() {
        // Inicializa a conexão usando a classe JBDCConnect
        this.conexao = new JBDCConnect();
    }
    
    public void InserirImovel(CadastroImovel cadastro) {
        //string com a consulta que será executada no banco
        String sql = "INSERT INTO imovel (idcliente_imovel, situacao, nomeimovel, descricao, valorpreco, CEPImovel, BairroImovel, EnderecoImovel, NumeroImovel, UFImovel, InscricaoImobiliaria, Matriculaimovel, AguaContrato, EnergiaContrato, IPTU)"
                + " VALUES (select idcliente_imovel from clientes where idCliente = ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
                ;
        
        
        // INSERT INTO `imovel` (`idimovel`, `idcliente_imovel`, `situacao`, `nomeimovel`, `descricao`, `valorpreco`, `CEPImovel`, `BairroImovel`, `EnderecoImovel`, `NumeroImovel`, `UFImovel`, `InscricaoImobiliaria`,
        //`Matriculaimovel`, `AguaContrato`, `EnergiaContrato`, `IPTU`) VALUES (NULL, '6', 'Venda', 'Casa dos Lagos', 'Casa Top', '1.232.4232', '85428-243', 'Vila A', 'Rua Puma', '231', 'PR', '12331241', '24123142', '31231242', '42312353', '1.521')
        try
        {
            //tenta realizar a conexão, se retornar verdadeiro entra no IF
            if(this.conexao.conectar())
            {
                //prepara a sentença com a consulta da string
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //subtitui as interrograções da consulta, pelo valor específico
                sentenca.setString(1,cadastro.getSituacao()); //subsitui a primeira ocorrência da interrogação pelo atributo nome
                sentenca.setInt(2,cadastro.getIdImovel());
                sentenca.setString(3,cadastro.getNomeImovel()); 
                sentenca.setString(4,cadastro.getNomeImovel());               
                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
}
