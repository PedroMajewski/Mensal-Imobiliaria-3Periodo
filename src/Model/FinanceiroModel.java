/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Patryk
 */
public class FinanceiroModel {
          
    private int idImovelFinanceiro;
    private int idimovel;
    private String nomeContrato;
    private String situacaoComboFinanceiro;
    private String numeroParcelas;
    private String valorParcela;
    private String valor_total;
    private String Locador;
    private String nome_imovel;

    //Insere os dados na tabela
    public FinanceiroModel(int idImovelFinanceiro,String nomeContrato,String Locador,String valorParcela, String numeroParcelas, String valor_total, String situacaoComboFinanceiro) {
  
        this.idImovelFinanceiro = idImovelFinanceiro;
        this.nomeContrato = nomeContrato;
        this.Locador = Locador;
        this.numeroParcelas = numeroParcelas;
        this.valorParcela = valorParcela;
        this.valor_total = valor_total;
        this.situacaoComboFinanceiro = situacaoComboFinanceiro;
    }
    
    public FinanceiroModel (String nomeContrato, String situacaoComboFinanceiro, String valorParcela, String numeroParcelas, String valor_total, String Locador, int idImovelFinanceiro){
        this.nomeContrato = nomeContrato;
        this.situacaoComboFinanceiro = situacaoComboFinanceiro;
        this.valorParcela = valorParcela;
        this.numeroParcelas = numeroParcelas;
        this.valor_total = valor_total;
        this.Locador = Locador;
        this.idImovelFinanceiro = idImovelFinanceiro;
    }
    
    public FinanceiroModel (int idimovel, String nome_imovel){
        this.idimovel = idimovel;
        this.nome_imovel = nome_imovel;
    }
    
    public FinanceiroModel( String nomeContrato,String situacaoComboFinanceiro,String numeroParcelas, String valorParcela, String valor_total, String Locador) {
  
        
        this.nomeContrato = nomeContrato;
        this.situacaoComboFinanceiro = situacaoComboFinanceiro;
        this.valorParcela = valorParcela;
        this.numeroParcelas = numeroParcelas;
        this.valor_total = valor_total;
        this.Locador = Locador;
    }

    public int getIdimovel() {
        return idimovel;
    }

    public void setIdimovel(int idimovel) {
        this.idimovel = idimovel;
    }

    public String getNome_imovel() {
        return nome_imovel;
    }

    public void setNome_imovel(String nome_imovel) {
        this.nome_imovel = nome_imovel;
    }
    
    public void setSituacaoComboFinanceiro(String SituacaoComboFinanceiro) {
        this.situacaoComboFinanceiro = SituacaoComboFinanceiro;
    }

    public String getSituacaoComboFinanceiro() {
        return situacaoComboFinanceiro;
    }
    public FinanceiroModel() {
    }


    public int getIdImovelFinanceiro() {
        return idImovelFinanceiro;
    }

    public void setIdImovelFinanceiro(int idImovelFinanceiro) {
        this.idImovelFinanceiro = idImovelFinanceiro;
    }
    
    public String getNomeContrato(){
        return nomeContrato;
    }
    
    public void setNomeContrato(String nomeContrato){
        this.nomeContrato = nomeContrato;
    }
    

    
    public String getNumeroParcelas(){
        return numeroParcelas;
    }
    
    public void setNumeroParcelas (String numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }
    
    public String getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(String valorParcela) {
        this.valorParcela = valorParcela;
    }

    public String getValor_total() {
        return valor_total;
    }

    public void setValor_total(String valor_total) {
        this.valor_total = valor_total;
    }
    
    public String getLocador() {
        return Locador;
    }

    public void setLocador(String Locador) {
        this.Locador = Locador;
    }
}
