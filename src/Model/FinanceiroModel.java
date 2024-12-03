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
          
    private int idImovelFinanceiro;    //idImovelFinanceiro Foreign IDIMOVEL
    private String nomeContrato;
    private String situacaoComboFinanceiro;
    private String numeroParcelas;
    private String valorParcela;
    private String valor_total;
    private String Locatario;
    private String Locador;

    //Insere os dados na tabela
    public FinanceiroModel(int idImovelFinanceiro,String nomeContrato,String situacaoComboFinanceiro,String numeroParcelas, String valorParcela, String valor_total, String Locador) {
  
        this.idImovelFinanceiro = idImovelFinanceiro;
        this.nomeContrato = nomeContrato;
        this.situacaoComboFinanceiro = situacaoComboFinanceiro;
        this.valorParcela = valorParcela;
        this.numeroParcelas = numeroParcelas;
        this.valor_total = valor_total;
        this.Locador = Locador;
    }
    
    public FinanceiroModel( String nomeContrato,String situacaoComboFinanceiro,String numeroParcelas, String valorParcela, String valor_total, String Locador) {
  
        
        this.nomeContrato = nomeContrato;
        this.situacaoComboFinanceiro = situacaoComboFinanceiro;
        this.valorParcela = valorParcela;
        this.numeroParcelas = numeroParcelas;
        this.valor_total = valor_total;
        this.Locador = Locador;
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
