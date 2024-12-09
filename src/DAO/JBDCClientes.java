/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.ClientesModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gm
 */
public class JBDCClientes {
    private JBDCConnect conexao;
   

    // Construtor da classe
    public JBDCClientes() {
        // Inicializa a conexão usando a classe JBDCConnect
        this.conexao = new JBDCConnect();
    }
            
    
    
    public void CadastroClientes(ClientesModel cadastroclientes){
        String sql = "INSERT INTO cliente (nome_cliente, celular_cliente, email_cliente, cep_cliente,"
                + " bairro_cliente, endereco_cliente, numero_cliente, uf_cliente, TipoDocumento,"
                + " Documento, cidade_cliente, Nascimento) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                
         try
        {
            //tenta realizar a conexão, se retornar verdadeiro entra no IF
            if(this.conexao.conectar())
            {
                //prepara a sentença com a consulta da string
                PreparedStatement ConexaoSentenca = this.conexao.getConnection().prepareStatement(sql);
                
                
                ConexaoSentenca.setString(1,cadastroclientes.getNomecliente());
                ConexaoSentenca.setString(3,cadastroclientes.getTelefonecliente());
                ConexaoSentenca.setString(4,cadastroclientes.getEmail());
                ConexaoSentenca.setString(5,cadastroclientes.getCepcliente());
                ConexaoSentenca.setString(6,cadastroclientes.getBairrocliente());
                ConexaoSentenca.setString(7,cadastroclientes.getEnderecocliente());
                ConexaoSentenca.setString(8,cadastroclientes.getNumerocliente());
                ConexaoSentenca.setString(9,cadastroclientes.getUf());
                ConexaoSentenca.setString(10,cadastroclientes.getTipoDocumento());
                ConexaoSentenca.setString(11,cadastroclientes.getDocumento());
                ConexaoSentenca.setString(12,cadastroclientes.getcidadecliente());
                ConexaoSentenca.setString(13,cadastroclientes.getNascimento());
                
                ConexaoSentenca.execute(); //executa o comando no banco
                ConexaoSentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }        
        
    }
    
    public void AtualizarCliete(ClientesModel cadastroclientes){
        String sql = "UPDATE cliente as c SET c.nome_cliente = ?,\n"
                + " c.celular_cliente = ?,\n"
                + " c.email_cliente = ?,\n"
                + " c.cep_cliente = ?,\n"
                + " c.bairro_cliente = ?,\n"
                + " c.endereco_cliente = ?,\n"
                + " c.numero_cliente = ?,\n"
                + " c.uf_cliente = ?,\n"
                + " c.TipoDocumento = ?,\n"
                + " c.Documento = ?\n"
                + " c.cidade_cliente = ?\n"
                + " c.Nascimento = ?\n"
                + "WHERE c.idcliente = ?";
                
         try
        {
            //tenta realizar a conexão, se retornar verdadeiro entra no IF
            if(this.conexao.conectar())
            {
                //prepara a sentença com a consulta da string
                PreparedStatement ConexaoSentenca = this.conexao.getConnection().prepareStatement(sql);
                
                
                ConexaoSentenca.setString(1,cadastroclientes.getNomecliente());
                ConexaoSentenca.setString(2,cadastroclientes.getTelefonecliente());
                ConexaoSentenca.setString(3,cadastroclientes.getEmail());
                ConexaoSentenca.setString(4,cadastroclientes.getCepcliente()); 
                ConexaoSentenca.setString(5,cadastroclientes.getBairrocliente());
                ConexaoSentenca.setString(6,cadastroclientes.getEnderecocliente());
                ConexaoSentenca.setString(7,cadastroclientes.getNumerocliente());
                ConexaoSentenca.setString(8,cadastroclientes.getUf());
                ConexaoSentenca.setString(9,cadastroclientes.getTipoDocumento());
                ConexaoSentenca.setString(10,cadastroclientes.getDocumento());
                ConexaoSentenca.setString(11,cadastroclientes.getcidadecliente());
                ConexaoSentenca.setString(12,cadastroclientes.getNascimento());
                ConexaoSentenca.setInt(12, cadastroclientes.getIdcliente());
                
                ConexaoSentenca.execute(); //executa o comando no banco
                ConexaoSentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
                
                
                
            }
            
            
              
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }        
        
    }
    
    
    
    public ArrayList<ClientesModel> MostrarListaclientes() {

        ArrayList<ClientesModel> ListaClientes = new ArrayList<ClientesModel>();
        String sql = "SELECT \n" +
"    c.idcliente, \n" +
"    c.nome_cliente, \n" +
"    c.celular_cliente, \n" +
"    c.email_cliente, \n" +
"    c.cep_cliente, \n" +
"    c.bairro_cliente, \n" +
"    c.endereco_cliente, \n" +
"    c.numero_cliente, \n" +
"    c.uf_cliente, \n" +
"    c.TipoDocumento, \n" +
"    c.Documento, \n" +
"    c.Nascimento, c.cidadecliente \n" +
"FROM \n" +
"    cliente AS c\n" +
"ORDER BY \n" +
"    c.idcliente;";
        
        
        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //recebe o resultado da consulta
                ResultSet SentencaCLientes = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while (SentencaCLientes.next()) {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    ClientesModel ClientesModel = new ClientesModel();
                    ClientesModel.setIdcliente(SentencaCLientes.getInt("idcliente"));
                    ClientesModel.setNomecliente(SentencaCLientes.getString("nome_cliente"));
                    ClientesModel.setTelefonecliente(SentencaCLientes.getString("celular_cliente"));
                    ClientesModel.setEmail(SentencaCLientes.getString("email_"));
                    ClientesModel.setCepcliente(SentencaCLientes.getString("cep_cliente"));
                    ClientesModel.setBairrocliente(SentencaCLientes.getString("bairro_cliente"));
                    ClientesModel.setEnderecocliente(SentencaCLientes.getString("endereco_cliente"));
                    ClientesModel.setNumerocliente(SentencaCLientes.getString("numero_cliente"));
                    ClientesModel.setUf(SentencaCLientes.getString("uf_cliente"));
                    ClientesModel.setTipoDocumento(SentencaCLientes.getString("TipoDocumento"));
                    ClientesModel.setDocumento(SentencaCLientes.getString("Documento"));
                    ClientesModel.setcidadecliente(SentencaCLientes.getString("cidade_cliente"));
                    ClientesModel.setNascimento(SentencaCLientes.getString("Nascimento"));
                  

                    ListaClientes.add(ClientesModel);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }

            return ListaClientes;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    
        public ArrayList<ClientesModel> ConsultaCliente(int IdCliente) {

        ArrayList<ClientesModel> ClienteSelecionado = new ArrayList<ClientesModel>();
                String sql = "SELECT \n" +
"    c.idcliente, \n" +
"    c.nome_cliente, \n" +
"    c.celular_cliente, \n" +
"    c.email_cliente, \n" +
"    c.cep_cliente, \n" +
"    c.bairro_cliente, \n" +
"    c.endereco_cliente, \n" +
"    c.numero_cliente, \n" +
"    c.uf_cliente, \n" +
"    c.TipoDocumento, \n" +
"    c.Documento, \n" +
"    c.cidadecliente \n" +
"FROM \n" +
"    cliente AS c\n" +
"WHERE \n" +
"    c.idcliente = ?;";
        
        
        
        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //recebe o resultado da consulta
                sentenca.setInt(1,IdCliente);
                ResultSet SentencaCLientes = sentenca.executeQuery();
                
                //percorrer cada linha do resultado
                while (SentencaCLientes.next()) {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    ClientesModel ClientesModel = new ClientesModel();
                    ClientesModel.setIdcliente(SentencaCLientes.getInt("idcliente"));
                    ClientesModel.setNomecliente(SentencaCLientes.getString("nome_cliente"));
                    ClientesModel.setTelefonecliente(SentencaCLientes.getString("celular_cliente"));
                    ClientesModel.setCepcliente(SentencaCLientes.getString("email_cliente"));
                    ClientesModel.setEnderecocliente(SentencaCLientes.getString("cep_cliente"));
                    ClientesModel.setNumerocliente(SentencaCLientes.getString("bairro_cliente"));
                    ClientesModel.setBairrocliente(SentencaCLientes.getString("endereco_cliente"));
                    ClientesModel.setUf(SentencaCLientes.getString("numero_cliente"));
                    ClientesModel.setTipoDocumento(SentencaCLientes.getString("uf_cliente"));
                    ClientesModel.setDocumento(SentencaCLientes.getString("TipoDocumento"));
                    ClientesModel.setEmail(SentencaCLientes.getString("Documento"));
                    ClientesModel.setcidadecliente(SentencaCLientes.getString("cidade_cliente"));
                    ClientesModel.setNascimento(SentencaCLientes.getString("Nascimento"));

                    GuardarClienteSelecionado.setClienteSelecionado(ClienteSelecionado);
                    ClienteSelecionado.add(ClientesModel);
                }
                
                sentenca.close();
                this.conexao.getConnection().close();
            }

            return ClienteSelecionado;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public void ExcluirCliente(ClientesModel IdClientes) {
        //string com a consulta que será executada no banco
        String sql = "DELETE FROM cliente WHERE cliente.idcliente = ?";
        
        try
        {
            //tenta realizar a conexão, se retornar verdadeiro entra no IF
            if(this.conexao.conectar())
            {
                //prepara a sentença com a consulta da string
                PreparedStatement ConexaoSentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //subtitui as interrograções da consulta, pelo valor específico
                ConexaoSentenca.setInt(1,IdClientes.getIdcliente()); //subsitui a primeira ocorrência da interrogação pelo atributo nome
                
                ConexaoSentenca.execute(); //executa o comando no banco
                ConexaoSentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
    
     public ArrayList <ClientesModel> FiltrarClientes(ClientesModel cadastro) {

        ArrayList<ClientesModel> ListaCliente = new ArrayList<ClientesModel>();
        int ValorConsulta = cadastro.getValorConsulta();
        String ColunaSelecionada = null;
        switch(ValorConsulta){
            case 0:
                ColunaSelecionada = "c.idcliente";
                break;
            case 1:
                ColunaSelecionada = "c.nome_cliente";
                break;
            case 2:
                ColunaSelecionada = "c.celular_cliente";
                break;
            case 3:
                ColunaSelecionada = "c.email_cliente";
                break;
            case 4:
                ColunaSelecionada = "c.Documento";
                break;
            case 5:
                ColunaSelecionada = "c.TipoDocumento";
                break;
        }
        String sql = "SELECT \n" +
"    c.idcliente, \n" +
"    c.nome_cliente, \n" +
"    c.celular_cliente, \n" +
"    c.email_cliente, \n" +
"    c.cep_cliente, \n" +
"    c.bairro_cliente, \n" +
"    c.endereco_cliente, \n" +
"    c.numero_cliente, \n" +
"    c.uf_cliente, \n" +
"    c.TipoDocumento, \n" +
"    c.Documento, \n" +
"    c.Nascimento, c.cidadecliente \n" +
"FROM \n" +
"    cliente AS c WHERE " + ColunaSelecionada + " LIKE ? \n" +
"ORDER BY \n" +
"    c.idcliente;";
        try {
            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //idImovel, Nome, Locador, Locatário, CEP, MatrículaImóvel, Preço
               switch(ValorConsulta){
            case 0:
                sentenca.setString(1,cadastro.getItemPesquisar());
                break;
            case 1:
                sentenca.setString(1,cadastro.getItemPesquisar());
                break;
            case 2:
                sentenca.setString(1,cadastro.getItemPesquisar());
                break;
            case 3:
                sentenca.setString(1,cadastro.getItemPesquisar());
                break;
            case 4:
                sentenca.setString(1,cadastro.getItemPesquisar());
                break;
            case 5:
                sentenca.setString(1,cadastro.getItemPesquisar());
                break;
            case 6:
                sentenca.setString(1,cadastro.getItemPesquisar());
                break;
            case 7:
                sentenca.setString(1,cadastro.getItemPesquisar());
                break;
            case 8:
                sentenca.setString(1,cadastro.getItemPesquisar());
                break;
            case 9:
                sentenca.setString(1,cadastro.getItemPesquisar());
        }

                //recebe o resultado da consulta
                ResultSet SentencaCLientes = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while (SentencaCLientes.next()) {
                    ClientesModel ClientesModel = new ClientesModel();
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela 
                    ClientesModel.setIdcliente(SentencaCLientes.getInt("idcliente"));
                    ClientesModel.setNomecliente(SentencaCLientes.getString("nome_cliente"));
                    ClientesModel.setTelefonecliente(SentencaCLientes.getString("celular_cliente"));
                    ClientesModel.setEmail(SentencaCLientes.getString("email_cliente"));
                    ClientesModel.setCepcliente(SentencaCLientes.getString("cep_cliente"));
                    ClientesModel.setBairrocliente(SentencaCLientes.getString("bairro_cliente"));
                    ClientesModel.setEnderecocliente(SentencaCLientes.getString("endereco_cliente"));
                    ClientesModel.setNumerocliente(SentencaCLientes.getString("numero_cliente"));
                    ClientesModel.setUf(SentencaCLientes.getString("uf_cliente"));
                    ClientesModel.setTipoDocumento(SentencaCLientes.getString("TipoDocumento"));
                    ClientesModel.setDocumento(SentencaCLientes.getString("Documento"));
                    ClientesModel.setcidadecliente(SentencaCLientes.getString("cidade_cliente"));
                    ClientesModel.setNascimento(SentencaCLientes.getString("Nascimento"));
                    

                    ListaCliente.add(ClientesModel);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }

           
            return ListaCliente;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
     
     
    public class GuardarClienteSelecionado {

        private static ArrayList<ClientesModel> ClienteSelecionado = new ArrayList<>();

        public static ArrayList<ClientesModel> getClienteSelecionado() {
            return ClienteSelecionado;
        }

        public static void setClienteSelecionado(ArrayList<ClientesModel> Cliente) {
            ClienteSelecionado = Cliente;
        }
    }
}
