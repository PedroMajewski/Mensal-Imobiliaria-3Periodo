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

    private int idFinanceiro;          //idFinanceiro PRIMARIA
    private int idImovelFinanceiro;    //idImovelFinanceiro Foreign IDIMOVEL
    private String situacaoFinanceiro;
    private String valorParcela;
    private String comimobiliariafinanceiro;
    private String iptu;
    private String condominio;
    private String energia;
    private String agua;
    private String lixo;
    private String gas;
    private String outros;
    private String abono;
    private String valor_total;
    private int Locatario = 0;

    //Insere os dados na tabela
    public FinanceiroModel(int idFinanceiro, int idImovelFinanceiro, String situacaoFinanceiro, String valorParcela, String comimobiliariafinanceiro, String iptu, String condominio, String energia, String agua, String lixo, String gas, String outros, String abono, String valor_total, int Locatario) {
        this.idFinanceiro = idFinanceiro;
        this.idImovelFinanceiro = idImovelFinanceiro;
        this.situacaoFinanceiro = situacaoFinanceiro;
        this.valorParcela = valorParcela;
        this.comimobiliariafinanceiro = comimobiliariafinanceiro;
        this.iptu = iptu;
        this.condominio = condominio;
        this.energia = energia;
        this.agua = agua;
        this.lixo = lixo;
        this.gas = gas;
        this.outros = outros;
        this.abono = abono;
        this.valor_total = valor_total;
        this.Locatario = Locatario;
    }
    public FinanceiroModel() {
    }

    

    public int getIdFinanceiro() {
        return idFinanceiro;
    }

    public void setIdFinanceiro(int idFinanceiro) {
        this.idFinanceiro = idFinanceiro;
    }

    public int getIdImovelFinanceiro() {
        return idImovelFinanceiro;
    }

    public void setIdImovelFinanceiro(int idImovelFinanceiro) {
        this.idImovelFinanceiro = idImovelFinanceiro;
    }

    public String getSituacaoFinanceiro() {
        return situacaoFinanceiro;
    }

    public void setSituacaoFinanceiro(String situacaoFinanceiro) {
        this.situacaoFinanceiro = situacaoFinanceiro;
    }

    public String getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(String valorParcela) {
        this.valorParcela = valorParcela;
    }

    public String getComimobiliariafinanceiro() {
        return comimobiliariafinanceiro;
    }

    public void setComimobiliariafinanceiro(String comimobiliariafinanceiro) {
        this.comimobiliariafinanceiro = comimobiliariafinanceiro;
    }

    public String getIptu() {
        return iptu;
    }

    public void setIptu(String iptu) {
        this.iptu = iptu;
    }

    public String getCondominio() {
        return condominio;
    }

    public void setCondominio(String condominio) {
        this.condominio = condominio;
    }

    public String getEnergia() {
        return energia;
    }

    public void setEnergia(String energia) {
        this.energia = energia;
    }

    public String getAgua() {
        return agua;
    }

    public void setAgua(String agua) {
        this.agua = agua;
    }

    public String getLixo() {
        return lixo;
    }

    public void setLixo(String lixo) {
        this.lixo = lixo;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getOutros() {
        return outros;
    }

    public void setOutros(String outros) {
        this.outros = outros;
    }

    public String getAbono() {
        return abono;
    }

    public void setAbono(String abono) {
        this.abono = abono;
    }

    public String getValor_total() {
        return valor_total;
    }

    public void setValor_total(String valor_total) {
        this.valor_total = valor_total;
    }

    public int getLocatario() {
        return Locatario;
    }

    public void setLocatario(int Locatario) {
        this.Locatario = Locatario;
    }

}
