/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author pedro
 */
public class CadastroImovelModel {
    private int idImovel;                  // idimovelPrimária
    private int idClienteImovel;           // idcliente_imovelÍndice
    private String situacao;               // situacao
    private String nomeImovel;             // nomeimovel
    private String descricao;              // descricao
    private String valorPreco;              // valorpreco
    private String cepImovel;              // CEPImovel
    private String bairroImovel;           // BairroImovel
    private String enderecoImovel;         // EnderecoImovel
    private String numeroImovel;           // NumeroImovel
    private String ufImovel;               // UFImovel
    private String inscricaoImobiliaria;   // InscricaoImobiliaria (pode ser nulo)
    private String matriculaImovel;        // Matriculaimovel (pode ser nulo)       // EnergiaContrato (pode ser nulo)
    private String iptu;  
    private String locador;
    private String locatario;// IPTU
    private String cidade;
    private String valorconsulta; //Retorna o filtro selecionado na parte da lista de Imóveis;
    private String itempesquisar; //o Que ser pesquisado no filtro de busca

    public CadastroImovelModel(){
        
    }
    
    //Inserir Dados na tabela - CREATE
    public CadastroImovelModel(int idClienteImovel, String situacao, String nomeImovel, String descricao, String valorPreco, String cepImovel
    , String bairroImovel, String enderecoImovel, String numeroImovel, String ufImovel, String inscricaoImobiliaria, String matriculaImovel
    , String iptu, String locador, String locatario, String cidade, String valorconsulta,String itempesquisar){
        this.idClienteImovel = idClienteImovel;
        this.situacao = situacao;
        this.nomeImovel = nomeImovel;
        this.descricao  = descricao;
        this.valorPreco = valorPreco;
        this.cepImovel = cepImovel;
        this.bairroImovel = bairroImovel;
        this.enderecoImovel = enderecoImovel;
        this.numeroImovel = numeroImovel;
        this.ufImovel = ufImovel;
        this.inscricaoImobiliaria = inscricaoImobiliaria;
        this.matriculaImovel = matriculaImovel;
        this.iptu = iptu;
        this.locador = locador;
        this.locatario = locatario;
        this.cidade = cidade;
        this.valorconsulta = valorconsulta;
        this.itempesquisar = itempesquisar;
        
    }
    
    //Inserir Dados na tabela - UPDATE
    public CadastroImovelModel(int idImovel,int idClienteImovel, String situacao, String nomeImovel, String descricao, String valorPreco, String cepImovel
    , String bairroImovel, String enderecoImovel, String numeroImovel, String ufImovel, String inscricaoImobiliaria, String matriculaImovel
    , String iptu, String locador, String locatario, String cidade, String valorconsulta,String itempesquisar){
        this.idImovel = idImovel;
        this.idClienteImovel = idClienteImovel;
        this.situacao = situacao;
        this.nomeImovel = nomeImovel;
        this.descricao  = descricao;
        this.valorPreco = valorPreco;
        this.cepImovel = cepImovel;
        this.bairroImovel = bairroImovel;
        this.enderecoImovel = enderecoImovel;
        this.numeroImovel = numeroImovel;
        this.ufImovel = ufImovel;
        this.inscricaoImobiliaria = inscricaoImobiliaria;
        this.matriculaImovel = matriculaImovel;
        this.iptu = iptu;
        this.locador = locador;
        this.locatario = locatario;
         this.cidade = cidade;
        this.valorconsulta = valorconsulta;
        this.itempesquisar = itempesquisar;
        
    }
    // Getters e Setters

    
    public String getValorConsulta(){
        return valorconsulta;
    }
    
    public void setValorConsulta(String valorconsulta){
        this.valorconsulta = valorconsulta;
    }
    
    public String getItemPesquisar(){
        return itempesquisar;
    }
    
    public void setItemPesquisar(String itempesquisar){
        this.itempesquisar = itempesquisar;
    }
    
    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }
    
    public String getCidade(){
        return cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
   

    public int getIdClienteImovel() {
        return idClienteImovel;
    }

    public void setIdClienteImovel(int idClienteImovel) {
        this.idClienteImovel = idClienteImovel;
    }
    

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getNomeImovel() {
        return nomeImovel;
    }

    public void setNomeImovel(String nomeImovel) {
        this.nomeImovel = nomeImovel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getLocatario() {
        return locatario;
    }

    public void setLocatario(String locatario) {
        this.locatario = locatario;
    }
    
    public String getLocador() {
        return locador;
    }

    public void setLocador(String locador) {
        this.locador = locador;
    }

    public String getValorPreco() {
        return valorPreco;
    }

    public void setValorPreco(String valorPreco) {
        this.valorPreco = valorPreco;
    }

    public String getCepImovel() {
        return cepImovel;
    }

    public void setCepImovel(String cepImovel) {
        this.cepImovel = cepImovel;
    }

    public String getBairroImovel() {
        return bairroImovel;
    }

    public void setBairroImovel(String bairroImovel) {
        this.bairroImovel = bairroImovel;
    }

    public String getEnderecoImovel() {
        return enderecoImovel;
    }

    public void setEnderecoImovel(String enderecoImovel) {
        this.enderecoImovel = enderecoImovel;
    }

    public String getNumeroImovel() {
        return numeroImovel;
    }

    public void setNumeroImovel(String numeroImovel) {
        this.numeroImovel = numeroImovel;
    }

    public String getUfImovel() {
        return ufImovel;
    }

    public void setUfImovel(String ufImovel) {
        this.ufImovel = ufImovel;
    }

    public String getInscricaoImobiliaria() {
        return inscricaoImobiliaria;
    }

    public void setInscricaoImobiliaria(String inscricaoImobiliaria) {
        this.inscricaoImobiliaria = inscricaoImobiliaria;
    }

    public String getMatriculaImovel() {
        return matriculaImovel;
    }

    public void setMatriculaImovel(String matriculaImovel) {
        this.matriculaImovel = matriculaImovel;
    }

    public String getIptu() {
        return iptu;
    }

    public void setIptu(String iptu) {
        this.iptu = iptu;
    }
}
