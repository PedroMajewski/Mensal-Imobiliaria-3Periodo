/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.CadastroClienteImovelModel;
import java.sql.PreparedStatement;
import DAO.JBDCConnect;
import Clientes.ClientesImovel;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author gm
 */
public class JBDCCadastroClientes {
        private JBDCConnect conexao;
    
    // Construtor da classe
    public JBDCCadastroClientes() {
        // Inicializa a conexão usando a classe JBDCConnect
        this.conexao = new JBDCConnect();
    }
    
    public void InserirCliente(CadastroClienteImovelModel cadastro){
        //Insere dados no banco
        String sql = "INSERT INTO cliente (nome_cliente, nascimento_cliente, "
                + "celular_cliente, telresidencial_cliente, email_cliente, nacionalidade_cliente, observacoes, "
                + "observacoes, is_locatario, cep_cliente, bairro_cliente, endereco_cliente, numero_cliente, "
                + "uf_cliente),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
        //tenta conexão
        try{
            if(this.conexao.conectar()){
                PreparedStatement ConexaoSentenca = this.conexao.getConnection().prepareStatement(sql);

                //subtitui as interrograções da consulta, pelo valor específico
                ConexaoSentenca.setString(1, cadastro.getNome_cliente());
                ConexaoSentenca.setString(2, cadastro.getNascimento_cliente());
                ConexaoSentenca.setString(3, cadastro.getCelular_cliente());
                ConexaoSentenca.setString(4, cadastro.getTelresidencial_cliente());
                ConexaoSentenca.setString(5, cadastro.getEmail_cliente());
                ConexaoSentenca.setString(6, cadastro.getNacionalidade_cliente());
                ConexaoSentenca.setString(7, cadastro.getObservacoes());
                ConexaoSentenca.setBoolean(8, cadastro.isIs_locatario());
                ConexaoSentenca.setString(9, cadastro.getCep_cliente());
                ConexaoSentenca.setString(10, cadastro.getBairro_cliente());
                ConexaoSentenca.setString(11, cadastro.getEndereco_cliente());
                ConexaoSentenca.setString(12, cadastro.getNumero_cliente());
                ConexaoSentenca.setString(13, cadastro.getUf_cliente());
                ConexaoSentenca.setInt(14, cadastro.getValorconsulta());
                ConexaoSentenca.setString(15, cadastro.getItempesquisar());
            
                ConexaoSentenca.execute();
                ConexaoSentenca.close();
                this.conexao.getConnection().close();
            }
        }
         catch(SQLException ex){
           throw new RuntimeException(ex);
        }
    }
    
    
    public void ExcluirCliente(CadastroClienteImovelModel CadastroIdCliente){
        String sql = "DELETE FROM cliente WHERE cliente.idcliente = ?";
        
        try{
            if(this.conexao.conectar()){
                PreparedStatement ConexaoSentenca = this.conexao.getConnection().prepareStatement(sql);
                
                ConexaoSentenca.setInt(1, CadastroIdCliente.getIdcliente());
                
                ConexaoSentenca.execute();
                ConexaoSentenca.close();
                this.conexao.getConnection().close();
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
    
    public void AtualizarCliente(CadastroClienteImovelModel cadastro){
        String sql = "UPDATE cliente AS c \n" +
                "   c.nome_cliente = ?, \n" +
                "   c.nascimento_cliente = ?, \n" +
                "   c.celular_cliente = ?, \n" +
                "   c.telresidencial_cliente = ?, \n" +
                "   c.email_cliente = ?, \n" +
                "   c.nacionalidade_cliente = ?, \n" +
                "   c.observacoes = ?, \n" +
                "   c.is_locatario = ? \n" +
                "   c.cep_cliente = ? \n" +
                "   c.bairro_cliente = ? \n" +
                "   c.endereco_cliente = ? \n" +
                "   c.numero_cliente = ? \n" +
                "   c.uf_cliente = ? \n" +
                "WHERE c.idcliente = ?";
        
        //tenta conexão
        try{
            if(this.conexao.conectar()){
                PreparedStatement ConexaoSentenca = this.conexao.getConnection().prepareStatement(sql);

                //subtitui as interrograções da consulta, pelo valor específico
                ConexaoSentenca.setString(1, cadastro.getNome_cliente());
                ConexaoSentenca.setString(2, cadastro.getNascimento_cliente());
                ConexaoSentenca.setString(3, cadastro.getCelular_cliente());
                ConexaoSentenca.setString(4, cadastro.getTelresidencial_cliente());
                ConexaoSentenca.setString(5, cadastro.getEmail_cliente());
                ConexaoSentenca.setString(6, cadastro.getNacionalidade_cliente());
                ConexaoSentenca.setString(7, cadastro.getObservacoes());
                ConexaoSentenca.setBoolean(8, cadastro.isIs_locatario());
                ConexaoSentenca.setString(9, cadastro.getCep_cliente());
                ConexaoSentenca.setString(10, cadastro.getBairro_cliente());
                ConexaoSentenca.setString(11, cadastro.getEndereco_cliente());
                ConexaoSentenca.setString(12, cadastro.getNumero_cliente());
                ConexaoSentenca.setString(13, cadastro.getUf_cliente());
                ConexaoSentenca.setInt(14, cadastro.getValorconsulta());
                ConexaoSentenca.setString(15, cadastro.getItempesquisar());
            
                ConexaoSentenca.execute();
                ConexaoSentenca.close();
                this.conexao.getConnection().close();
            }
        }
         catch(SQLException ex){
           throw new RuntimeException(ex);
        }
    }
}
    
    /*public ArrayList<CadastroClienteImovelModel> MostraListaCliente() {
        
    ArrayList<CadastroClienteImovelModel> listaCliente = new ArrayList<CadastroClienteImovelModel>();
    String sql = "SELECT \n" +
            "   c.idcliente, \n" +
            "   c.nome_cliente, \n" +
            "   c.nascimento_cliente, \n" +
            "   c.celular_cliente, \n" +
            "   c.telresidencial_cliente, \n" +
            "   c.email_cliente, \n" +
            "   c.nacionalidade_cliente, \n" +
            "   c.observacoes, \n" +
            "   c.is_locatario, \n" +
            "   c.cep_client, \n" +
            "   c.bairro_cliente, \n" +
            "   c.endereco_cliente, \n" +
            "   c.numero_cliente, \n" +
            "   c.uf_cliente \n" +
            "FROM \n"+
            "   cliente AS c\n" +
            "ORDER BY \n" +
            "   c.idcliente;";
    
        try{
            if(this.conexao.conectar()){
                PreparedStatement SentencaCli = this.conexao.getConnection().prepareStatement(sql);
                
                ResultSet SentencaCliente = SentencaCli.executeQuery();
                
                while (SentencaCliente.next()) {
                    CadastroClienteImovelModel ClienteModel = new CadastroClienteImovelModel();
                    
                    ClienteModel.setIdcliente(SentencaCliente.getInt("idcliente"));
                    ClienteModel.setNome_cliente(SentencaCliente.getString("nome_cliente"));
                    ClienteModel.setNascimento_cliente(SentencaCliente.getString("nascimento_cliente"));
                    ClienteModel.setCelular_cliente(SentencaCliente.getString("celular_cliente"));
                    ClienteModel.setTelresidencial_cliente(SentencaCliente.getString("telresidencial_cliente"));
                    ClienteModel.setEmail_cliente(SentencaCliente.getString("email_cliente"));
                    ClienteModel.setNacionalidade_cliente(SentencaCliente.getString("nacionalidade_cliente"));
                    ClienteModel.setObservacoes(SentencaCliente.getString("observacoes"));
                    ClienteModel.setIs_locatario(SentencaCliente.getBoolean("is_locatario"));
                    ClienteModel.setCep_cliente(SentencaCliente.getString("cep_client"));
                    ClienteModel.setBairro_cliente(SentencaCliente.getString("bairro_cliente"));
                    ClienteModel.setEndereco_cliente(SentencaCliente.getString("endereco_cliente"));
                    ClienteModel.setNumero_cliente(SentencaCliente.getString("numero_cliente"));
                    ClienteModel.setUf_cliente(SentencaCliente.getString("uf_cliente"));
                    
                    listaCliente.add(ClienteModel);
                }
                
                SentencaCli.close();
                this.conexao.getConnection().close();
            }
            return listaCliente;
        } 
        catch(SQLException ex) {
        throw new RuntimeException(ex);
    }
   }
    
    public class GuardarClienteSelecionado {
        private static ArrayList<CadastroClienteImovelModel> clienteSelecionado = new ArrayList<>();
    
        public static ArrayList<CadastroClienteImovelModel> getClienteSelecionado() {
            clienteSelecionado = clientes;
        }
    
    }
    
    public ArrayList <CadastroClienteImovelModel> FiltrarCliente(CadastroClienteImovelModel cadastro) {
        
        ArrayList<CadastroClienteImovelModel> ListaCliente = new ArrayList<CadastroClienteImovelModel>();
        int ValorConCli = cadastro.getValorconsulta();
        String ColunaSelecionada = null;
        switch(ValorConCli){
            case 0:
                ColunaSelecionada = "c.idcliente";
                break;
            case 1:
                ColunaSelecionada = "c.nome_cliente";
                break;
            case 2:
                ColunaSelecionada = "c.nascimento_cliente";
                break;
            case 3:
                ColunaSelecionada = "c.celular_cliente";
                break;
            case 4:
                ColunaSelecionada = "c.telresidencial_cliente";
                break;
            case 5:
                ColunaSelecionada = "c.email_cliente";
                break;
            case 6:
                ColunaSelecionada = "c.nacionalidade_cliente";
                break;
            case 7:
                ColunaSelecionada = "c.observacoes";
                break;
            case 8:
                ColunaSelecionada = "c.is_locatario";
                break;
            case 9:
                ColunaSelecionada = "c.cep_cliente";
                break;
            case 10:
                ColunaSelecionada = "c.bairro_cliente";
                break;
            case 11:
                ColunaSelecionada = "c.endereco_cliente";
                break;
            case 12:
                ColunaSelecionada = "c.numero_cliente";
                break;
            case 13:
                ColunaSelecionada = "c.uf_cliente";
                break;
        }
      } 
    }
}*/
  
