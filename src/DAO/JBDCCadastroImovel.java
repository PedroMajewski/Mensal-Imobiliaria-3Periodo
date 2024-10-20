/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import Model.CadastroImovelModel;
import java.sql.PreparedStatement;
import DAO.JBDCConnect;
import java.util.ArrayList;
import java.sql.ResultSet;
import Model.CadastroImovelModel;
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
    
    public void InserirImovel(CadastroImovelModel cadastro) {
        //string com a consulta que será executada no banco
        String sql = "INSERT INTO imovel (id_situacao, nome_imovel, "
                + "descricao, valor_preco, cep_imovel, bairro_imovel, endereco_imovel, "
                + "numero_imovel, uf_imovel, inscricao_imobiliaria, matricula_imovel, iptu, locador_imovel, "
                + "locatario_imovel, cidade) VALUES ((select idsituacaoimovel from situacao_imovel where situacao_atual = ?),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        
        // INSERT INTO `imovel` (`idimovel`, `idcliente_imovel`, `situacao`, `nomeimovel`, `descricao`, `valorpreco`, `CEPImovel`, `BairroImovel`, `EnderecoImovel`, `NumeroImovel`, `UFImovel`, `InscricaoImobiliaria`,
        //`Matriculaimovel`, `AguaContrato`, `EnergiaContrato`, `IPTU`) VALUES (NULL, '6', 'Venda', 'Casa dos Lagos', 'Casa Top', '1.232.4232', '85428-243', 'Vila A', 'Rua Puma', '231', 'PR', '12331241', '24123142', '31231242', '42312353', '1.521')
        try
        {
            //tenta realizar a conexão, se retornar verdadeiro entra no IF
            if(this.conexao.conectar())
            {
                //prepara a sentença com a consulta da string
                PreparedStatement ConexaoSentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //subtitui as interrograções da consulta, pelo valor específico
                ConexaoSentenca.setString(1,cadastro.getSituacao()); //subsitui a primeira ocorrência da interrogação pelo atributo nome
                ConexaoSentenca.setString(2,cadastro.getNomeImovel());
                ConexaoSentenca.setString(3,cadastro.getDescricao()); 
                ConexaoSentenca.setString(4,cadastro.getValorPreco());
                ConexaoSentenca.setString(5,cadastro.getCepImovel());
                ConexaoSentenca.setString(6,cadastro.getBairroImovel());
                ConexaoSentenca.setString(7,cadastro.getEnderecoImovel());
                ConexaoSentenca.setString(8,cadastro.getNumeroImovel());
                ConexaoSentenca.setString(9,cadastro.getUfImovel());
                ConexaoSentenca.setString(10,cadastro.getInscricaoImobiliaria());
                ConexaoSentenca.setString(11,cadastro.getMatriculaImovel());
                ConexaoSentenca.setString(12,cadastro.getIptu());
                ConexaoSentenca.setString(13,cadastro.getLocador());
                ConexaoSentenca.setString(14,cadastro.getLocatario());
                    ConexaoSentenca.setString(15,cadastro.getCidade());
                
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
    
    
    public ArrayList<CadastroImovelModel> ConsultarImovel() {

        ArrayList<CadastroImovelModel> listaImovel = new ArrayList<CadastroImovelModel>();
        String sql = "SELECT \n" +
"    i.idimovel, \n" +
"    i.nome_imovel, \n" +
"    i.descricao, \n" +
"    i.valor_preco, \n" +
"    i.cep_imovel, \n" +
"    i.bairro_imovel, \n" +
"    i.endereco_imovel, \n" +
"    i.numero_imovel, \n" +
"    i.uf_imovel, \n" +
"    i.inscricao_imobiliaria, \n" +
"    i.matricula_imovel, \n" +
"    i.iptu, \n" +
"    i.locador_imovel, \n" +
"    i.locatario_imovel, \n" +
"    i.cidade,\n" +
"    s.situacao_atual\n" +
"FROM \n" +
"    imovel AS i\n" +
"LEFT JOIN \n" +
"    situacao_imovel AS s ON (s.idsituacaoimovel = i.id_situacao)\n" +
"ORDER BY \n" +
"    i.idimovel;";
        
        
        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //recebe o resultado da consulta
                ResultSet SentecaImovel = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while (SentecaImovel.next()) {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    CadastroImovelModel ImovelModel = new CadastroImovelModel();
                    ImovelModel.setIdImovel(SentecaImovel.getInt("idimovel"));
                    ImovelModel.setNomeImovel(SentecaImovel.getString("nome_imovel"));
                    ImovelModel.setDescricao(SentecaImovel.getString("descricao"));
                    ImovelModel.setValorPreco(SentecaImovel.getString("valor_preco"));
                    ImovelModel.setCepImovel(SentecaImovel.getString("cep_imovel"));
                    ImovelModel.setBairroImovel(SentecaImovel.getString("bairro_imovel"));
                    ImovelModel.setEnderecoImovel(SentecaImovel.getString("endereco_imovel"));
                    ImovelModel.setNumeroImovel(SentecaImovel.getString("numero_imovel"));
                    ImovelModel.setUfImovel(SentecaImovel.getString("uf_imovel"));
                    ImovelModel.setInscricaoImobiliaria(SentecaImovel.getString("inscricao_imobiliaria"));
                    ImovelModel.setMatriculaImovel(SentecaImovel.getString("matricula_imovel"));
                    ImovelModel.setIptu(SentecaImovel.getString("iptu"));
                    ImovelModel.setLocador(SentecaImovel.getString("locador_imovel"));
                    ImovelModel.setLocatario(SentecaImovel.getString("locatario_imovel"));
                    ImovelModel.setCidade(SentecaImovel.getString("cidade"));
                    ImovelModel.setSituacao(SentecaImovel.getString("situacao_atual"));

                    listaImovel.add(ImovelModel);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }

            return listaImovel;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
