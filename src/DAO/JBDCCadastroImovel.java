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
                + "numero_imovel, uf_imovel, inscricao_imobiliaria, matricula_imovel, agua_contrato, energia_contrato, iptu, locador_imovel, "
                + "locatario_imovel) VALUES ((select idsituacaoimovel from situacao_imovel where situacao_atual = ?),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        
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
                ConexaoSentenca.setString(12,cadastro.getAguaContrato());
                ConexaoSentenca.setString(13,cadastro.getEnergiaContrato());
                ConexaoSentenca.setString(14,cadastro.getIptu());
                ConexaoSentenca.setString(15,cadastro.getLocador());
                ConexaoSentenca.setString(16,cadastro.getLocatario());
                
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
        String sql = "SELECT c.idcad, c.nomecad, c.cpf, c.email, s.nomesexo "
                + "FROM cadbasico as c "
                + "LEFT JOIN cadsexo AS s ON (s.idsexo = c.idsexo) "
                + "ORDER BY c.idcad ";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //recebe o resultado da consulta
                ResultSet SentecaImovel = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while (SentecaImovel.next()) {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    CadastroImovelModel ImovelModel = new CadastroImovelModel();
                    //ImovelModel.setid(SentecaImovel.getInt("idcad"));;;
                    //ImovelModel.setNomeCad(SentecaImovel.getString("nomecad"));
                    //ImovelModel.setCpf(SentecaImovel.getString("cpf"));
                   // ImovelModel.SetNomeSexo(SentecaImovel.getString("nomesexo"));
                    //ImovelModel.setEmail(SentecaImovel.getString("email"));

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
