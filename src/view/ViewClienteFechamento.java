/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author wolverine
 */
@Entity
@Table(name = "viewClienteFechamento")
@NamedQueries({
    @NamedQuery(name = "ViewClienteFechamento.findAll", query = "SELECT v FROM ViewClienteFechamento v")})
public class ViewClienteFechamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "nome")
    @Id
    private String nome;
    @Column(name = "fonefixo")
    private String fonefixo;
    @Column(name = "foneCelular")
    private String foneCelular;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorConta")
    private Double valorConta;
    @Column(name = "Datavencimento")
    @Temporal(TemporalType.DATE)
    private Date datavencimento;
    @Column(name = "valorCredito")
    private Double valorCredito;
    @Column(name = "valorPagar")
    private Double valorPagar;
    @Column(name = "situacao")
    private String situacao;
    @Column(name = "diasAtraso")
    private Integer diasAtraso;
    @Basic(optional = false)
    @Column(name = "fechamentomes_idfechamentomes")
    private int fechamentomesIdfechamentomes;
    @Column(name = "tipoFechamento")
    private String tipoFechamento;
    @Column(name = "diaPagamento")
    private Integer diaPagamento;
    @Column(name = "formaPagamento")
    private String formaPagamento;

    public ViewClienteFechamento() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFonefixo() {
        return fonefixo;
    }

    public void setFonefixo(String fonefixo) {
        this.fonefixo = fonefixo;
    }

    public String getFoneCelular() {
        return foneCelular;
    }

    public void setFoneCelular(String foneCelular) {
        this.foneCelular = foneCelular;
    }

    public Double getValorConta() {
        return valorConta;
    }

    public void setValorConta(Double valorConta) {
        this.valorConta = valorConta;
    }

    public Date getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(Date datavencimento) {
        this.datavencimento = datavencimento;
    }

    public Double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(Double valorCredito) {
        this.valorCredito = valorCredito;
    }

    public Double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(Double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Integer getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(Integer diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public int getFechamentomesIdfechamentomes() {
        return fechamentomesIdfechamentomes;
    }

    public void setFechamentomesIdfechamentomes(int fechamentomesIdfechamentomes) {
        this.fechamentomesIdfechamentomes = fechamentomesIdfechamentomes;
    }

    public String getTipoFechamento() {
        return tipoFechamento;
    }

    public void setTipoFechamento(String tipoFechamento) {
        this.tipoFechamento = tipoFechamento;
    }

    public Integer getDiaPagamento() {
        return diaPagamento;
    }

    public void setDiaPagamento(Integer diaPagamento) {
        this.diaPagamento = diaPagamento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
}
