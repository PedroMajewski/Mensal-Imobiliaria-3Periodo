/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gm
 */
public class CadastroClienteImovelModel {
    private int idcliente;
    private String nome_cliente;
    private String nascimento_cliente;
    private String celular_cliente;
    private String telresidencial_cliente;
    private String email_cliente;
    private String nacionalidade_cliente;
    private String observacoes;
    private Boolean is_locatario;
    private String cep_cliente;
    private String bairro_cliente;
    private String endereco_cliente;
    private String numero_cliente;
    private String uf_cliente;
    private int valorconsulta; //Retorna o filtro selecionado na parte da lista de Imóveis;
    private String itempesquisar; //o Que ser pesquisado no filtro de busca
    
    public CadastroClienteImovelModel(){
    
    }

    //INSERT
    public CadastroClienteImovelModel(String nome_cliente, 
    String nascimento_cliente, 
    String celular_cliente, 
    String telresidencial_cliente, 
    String email_cliente, 
    String nacionalidade_cliente, 
    String observacoes,
    Boolean is_locatario, 
    String cep_cliente, 
    String bairro_cliente, 
    String endereco_cliente, 
    String numero_cliente, 
    String uf_cliente, 
    int valorconsulta, 
    String itempesquisar){
        this.nome_cliente = nome_cliente;
        this.nascimento_cliente = nascimento_cliente;
        this.celular_cliente = celular_cliente;
        this.telresidencial_cliente = telresidencial_cliente;
        this.email_cliente = email_cliente;
        this.nacionalidade_cliente = nacionalidade_cliente;
        this.observacoes = observacoes;
        this.is_locatario = is_locatario;
        this.cep_cliente = cep_cliente;
        this.bairro_cliente = bairro_cliente;
        this.endereco_cliente = endereco_cliente;
        this.numero_cliente = numero_cliente;
        this.uf_cliente = uf_cliente;
        this.valorconsulta = valorconsulta;
        this.itempesquisar = itempesquisar;
    }
    
    //UPDATE
    public CadastroClienteImovelModel(int idcliente,
    String nome_cliente, 
    String nascimento_cliente, 
    String celular_cliente, 
    String telresidencial_cliente, 
    String email_cliente, 
    String nacionalidade_cliente, 
    String observacoes,
    Boolean is_locatario, 
    String cep_cliente, 
    String bairro_cliente, 
    String endereco_cliente, 
    String numero_cliente, 
    String uf_cliente, 
    int valorconsulta, 
    String itempesquisar){
        this.idcliente = idcliente;
        this.nome_cliente = nome_cliente;
        this.nascimento_cliente = nascimento_cliente;
        this.celular_cliente = celular_cliente;
        this.telresidencial_cliente = telresidencial_cliente;
        this.email_cliente = email_cliente;
        this.nacionalidade_cliente = nacionalidade_cliente;
        this.observacoes = observacoes;
        this.is_locatario = is_locatario;
        this.cep_cliente = cep_cliente;
        this.bairro_cliente = bairro_cliente;
        this.endereco_cliente = endereco_cliente;
        this.numero_cliente = numero_cliente;
        this.uf_cliente = uf_cliente;
        this.valorconsulta = valorconsulta;
        this.itempesquisar = itempesquisar;
    }
    
    
    // Getters and Setters
    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getNascimento_cliente() {
        return nascimento_cliente;
    }

    public void setNascimento_cliente(String nascimento_cliente) {
        this.nascimento_cliente = nascimento_cliente;
    }

    public String getCelular_cliente() {
        return celular_cliente;
    }

    public void setCelular_cliente(String celular_cliente) {
        this.celular_cliente = celular_cliente;
    }

    public String getTelresidencial_cliente() {
        return telresidencial_cliente;
    }

    public void setTelresidencial_cliente(String telresidencial_cliente) {
        this.telresidencial_cliente = telresidencial_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getNacionalidade_cliente() {
        return nacionalidade_cliente;
    }

    public void setNacionalidade_cliente(String nacionalidade_cliente) {
        this.nacionalidade_cliente = nacionalidade_cliente;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public boolean isIs_locatario() {
        return is_locatario;
    }

    public void setIs_locatario(boolean is_locatario) {
        this.is_locatario = is_locatario;
    }

    public String getCep_cliente() {
        return cep_cliente;
    }

    public void setCep_cliente(String cep_cliente) {
        this.cep_cliente = cep_cliente;
    }

    public String getBairro_cliente() {
        return bairro_cliente;
    }

    public void setBairro_cliente(String bairro_cliente) {
        this.bairro_cliente = bairro_cliente;
    }

    public String getEndereco_cliente() {
        return endereco_cliente;
    }

    public void setEndereco_cliente(String endereco_cliente) {
        this.endereco_cliente = endereco_cliente;
    }

    public String getNumero_cliente() {
        return numero_cliente;
    }

    public void setNumero_cliente(String numero_cliente) {
        this.numero_cliente = numero_cliente;
    }

    public String getUf_cliente() {
        return uf_cliente;
    }

    public void setUf_cliente(String uf_cliente) {
        this.uf_cliente = uf_cliente;
    }

    public int getValorconsulta() {
        return valorconsulta;
    }

    public void setValorconsulta(int valorconsulta) {
        this.valorconsulta = valorconsulta;
    }

    public String getItempesquisar() {
        return itempesquisar;
    }

    public void setItempesquisar(String itempesquisar) {
        this.itempesquisar = itempesquisar;
    }
}



