/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author wolverine
 */
@Entity
@Table(name = "parcelacartao")
public class Parcelacartao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idparcelaCartao")
    private Integer idparcelaCartao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorCobrado")
    private Float valorCobrado;
    @Column(name = "numeroParcela")
    private Integer numeroParcela;
    @Column(name = "percentualcomissao")
    private Double percentualcomissao;
    @Column(name = "valorComissao")
    private Float valorComissao;
    @Column(name = "valorReceber")
    private Float valorReceber;
    @Column(name = "dataRecebimento")
    @Temporal(TemporalType.DATE)
    private Date dataRecebimento;
    @Column(name = "formaVenda")
    private int formaVenda;
    @Column(name = "formaContasReceber")
    private int formaContasReceber;
    @Column(name = "banco_idbanco")
    private int banco;
    @Column(name = "empresa_idempresa")
    private int empresa;
    
    


    public Parcelacartao() {
    }

    public Parcelacartao(Integer idparcelaCartao) {
        this.idparcelaCartao = idparcelaCartao;
    }

    public Integer getIdparcelaCartao() {
        return idparcelaCartao;
    }

    public void setIdparcelaCartao(Integer idparcelaCartao) {
        this.idparcelaCartao = idparcelaCartao;
    }

    public int getFormaContasReceber() {
        return formaContasReceber;
    }

    public void setFormaContasReceber(int formaContasReceber) {
        this.formaContasReceber = formaContasReceber;
    }

    public Float getValorCobrado() {
        return valorCobrado;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public void setValorCobrado(Float valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public Integer getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(Integer numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public Double getPercentualcomissao() {
        return percentualcomissao;
    }

    public void setPercentualcomissao(Double percentualcomissao) {
        this.percentualcomissao = percentualcomissao;
    }

    public Float getValorComissao() {
        return valorComissao;
    }

    public void setValorComissao(Float valorComissao) {
        this.valorComissao = valorComissao;
    }

    public Float getValorReceber() {
        return valorReceber;
    }

    public void setValorReceber(Float valorReceber) {
        this.valorReceber = valorReceber;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public int getFormaVenda() {
        return formaVenda;
    }

    public void setFormaVenda(int formaVenda) {
        this.formaVenda = formaVenda;
    }

    public int getBanco() {
        return banco;
    }

    public void setBanco(int banco) {
        this.banco = banco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparcelaCartao != null ? idparcelaCartao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parcelacartao)) {
            return false;
        }
        Parcelacartao other = (Parcelacartao) object;
        if ((this.idparcelaCartao == null && other.idparcelaCartao != null) || (this.idparcelaCartao != null && !this.idparcelaCartao.equals(other.idparcelaCartao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Parcelacartao[ idparcelaCartao=" + idparcelaCartao + " ]";
    }
    
}
