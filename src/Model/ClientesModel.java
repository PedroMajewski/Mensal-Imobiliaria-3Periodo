/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gm
 */
public class ClientesModel {
    private int idcliente;
    private String nomecliente;
    private String telefonecliente;
    private String cepcliente;
    private String enderecocliente;
    private String numerocliente;
    private String bairrocliente;
    private String uf;
    private String cidadecliente;
    private String tipoDocumento;
    private String documento;
    private String email;
    private String itempesquisar;
    private int valorconsulta;

    public ClientesModel() {
    }

    public ClientesModel(int idcliente, String nomecliente, String telefonecliente, String cepcliente, 
                                String enderecocliente, String numerocliente, String bairrocliente, 
                                String uf, String tipoDocumento, String documento, String email, int valorconsulta, String itempesquisar, String cidadecliente) {
        this.idcliente = idcliente;
        this.nomecliente = nomecliente;
        this.telefonecliente = telefonecliente;
        this.cepcliente = cepcliente;
        this.enderecocliente = enderecocliente;
        this.numerocliente = numerocliente;
        this.bairrocliente = bairrocliente;
        this.uf = uf;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.email = email;
        this.cidadecliente = cidadecliente;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }
    
    public String getcidadecliente() {
        return cidadecliente;
    }

    public void setcidadecliente(String cidadecliente) {
        this.cidadecliente = cidadecliente;
    }

    public String getTelefonecliente() {
        return telefonecliente;
    }

    public void setTelefonecliente(String telefonecliente) {
        this.telefonecliente = telefonecliente;
    }

    public String getCepcliente() {
        return cepcliente;
    }

    public void setCepcliente(String cepcliente) {
        this.cepcliente = cepcliente;
    }

    public String getEnderecocliente() {
        return enderecocliente;
    }

    public void setEnderecocliente(String enderecocliente) {
        this.enderecocliente = enderecocliente;
    }

    public String getNumerocliente() {
        return numerocliente;
    }

    public void setNumerocliente(String numerocliente) {
        this.numerocliente = numerocliente;
    }

    public String getBairrocliente() {
        return bairrocliente;
    }

    public void setBairrocliente(String bairrocliente) {
        this.bairrocliente = bairrocliente;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     public int getValorConsulta() {
        return valorconsulta;
    }

    public void setValorConsulta(int valorconsulta) {
        this.valorconsulta = valorconsulta;
    }
    
     public String getItemPesquisar() {
        return itempesquisar;
    }

    public void setItemPesquisar(String itempesquisar) {
        this.itempesquisar = itempesquisar;
    }
}

