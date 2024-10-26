/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gabri
 */
public class CadastroContratoModel {
    private int idcontrato;
    private int id_cliente_contrato;
    private int id_localizacao_imovel;
    private String inicio_contrato;
    private String fim_contrato;
    private String tempo_de_contrato;
    private String data_locacao;
    private String data_pagamento;
    private String situacao_imovel;
    private float comissao_imobiliaria;
    private String observacoes;
    
    public CadastroContratoModel(){
        
    }
    
    public CadastroContratoModel (int id_cliente_contrato, int id_localizacao_imovel, String inicio_contrato, String fim_contrato, String tempo_de_contrato, String data_locacao,
     String data_pagamento, String situacao_imovel, float comissao_imobiliaria, String observacoes){
        this.id_cliente_contrato = id_cliente_contrato;
        this.id_localizacao_imovel = id_localizacao_imovel;
        this.inicio_contrato = inicio_contrato;
        this.fim_contrato = fim_contrato;
        this.tempo_de_contrato = tempo_de_contrato;
        this.data_locacao = data_locacao;
        this.data_pagamento = data_pagamento;
        this.situacao_imovel = situacao_imovel;
        this.comissao_imobiliaria = comissao_imobiliaria;
        this.observacoes = observacoes;
    }
    
    public CadastroContratoModel (int idcontrato, int id_cliente_contrato, int id_localizacao_imovel, String inicio_contrato, String fim_contrato, String tempo_de_contrato, String data_locacao,
     String data_pagamento, String situacao_imovel, float comissao_imobiliaria, String observacoes){
        this.idcontrato = idcontrato;
        this.id_cliente_contrato = id_cliente_contrato;
        this.id_localizacao_imovel = id_localizacao_imovel;
        this.inicio_contrato = inicio_contrato;
        this.fim_contrato = fim_contrato;
        this.tempo_de_contrato = tempo_de_contrato;
        this.data_locacao = data_locacao;
        this.data_pagamento = data_pagamento;
        this.situacao_imovel = situacao_imovel;
        this.comissao_imobiliaria = comissao_imobiliaria;
        this.observacoes = observacoes;
    }
    
    public int getidcontrato(){
        return idcontrato;
    }
    
    public void setidcontrato (int idcontrato){
        this.idcontrato = idcontrato;
    }
    
    public int getid_cliente_contrato(){
        return id_cliente_contrato;
    }
    
    public void setid_cliente_contrato (int id_cliente_contrato){
        this.id_cliente_contrato  =  id_cliente_contrato;
    }
    
    public int getid_localizacao_imovel(){
        return id_localizacao_imovel;
    }
    
    public void setid_localizacao_imovel(int id_localizacao_imovel){
        this.id_localizacao_imovel = id_localizacao_imovel;
    }
    
     public String getinicio_contrato() {
        return inicio_contrato;
    }

    public void setinicio_contrato(String inicio_contrato) {
        this.inicio_contrato = inicio_contrato;
    }

    public String getfim_contrato() {
        return fim_contrato;
    }

    public void setfim_contrato(String fim_contrato) {
        this.fim_contrato = fim_contrato;
    }

    public String gettempo_de_contrato() {
        return tempo_de_contrato;
    }

    public void settempo_de_contrato(String tempo_de_contrato) {
        this.tempo_de_contrato = tempo_de_contrato;
    }

    public String getdata_locacao() {
        return data_locacao;
    }

    public void setdata_locacao(String data_locacao) {
        this.data_locacao = data_locacao;
    }

    public String getdata_pagamento() {
        return data_pagamento;
    }

    public void setdata_pagamento(String data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public String getsituacao_imovel() {
        return situacao_imovel;
    }

    public void setsituacao_imovel(String situacao_imovel) {
        this.situacao_imovel = situacao_imovel;
    }

    public float getcomissao_imobiliaria() {
        return comissao_imobiliaria;
    }

    public void setcomissao_imobiliaria(float comissao_imobiliaria) {
        this.comissao_imobiliaria = comissao_imobiliaria;
    }

    public String getobservacoes() {
        return observacoes;
    }

    public void setobservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
}